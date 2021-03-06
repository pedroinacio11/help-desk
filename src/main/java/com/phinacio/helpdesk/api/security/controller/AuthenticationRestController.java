package com.phinacio.helpdesk.api.security.controller;

import com.phinacio.helpdesk.api.security.jwt.JwtTokenUtil;
import com.phinacio.helpdesk.api.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pedro.inacio on 20/02/2019.
 */

@RestController
@CrossOrigin(origins = "*")
public class AuthenticationRestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

}
