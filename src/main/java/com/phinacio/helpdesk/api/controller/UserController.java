package com.phinacio.helpdesk.api.controller;

import com.phinacio.helpdesk.api.entity.User;
import com.phinacio.helpdesk.api.response.Response;
import com.phinacio.helpdesk.api.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pedro.inacio on 23/04/2019.
 */

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Response<User>> create(HttpServletRequest request, @RequestBody User user, BindingResult result) {

        Response<User> response = new Response<User>();

        try {
            validateCreateUser(user, result);
            if(result.hasErrors()){
                result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
                return ResponseEntity.badRequest().body(response);
            }

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User userPersisted = (User) userService.createOrUpdate(user);
            response.setData(userPersisted);

        } catch (DuplicateKeyException dE){
            response.getErrors().add("Email already registered");
            return ResponseEntity.badRequest().body(response);
        } catch (Exception e){
            response.getErrors().add(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }


        return ResponseEntity.ok(response);

    }

    private void validateCreateUser(User user, BindingResult result){
        if(user.getEmail() == null){
            result.addError(new ObjectError("User", "Email no information"));
        }
    }

}