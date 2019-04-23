package com.phinacio.helpdesk.api.security.service;

import com.phinacio.helpdesk.api.entity.User;
import com.phinacio.helpdesk.api.security.jwt.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by pedro.inacio on 20/09/2018.
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userService.findByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s' .", email));

        }else {
            return JwtUserFactory.create(user);
        }
    }
}
