package com.springdocker.app.oauth.events;

import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEventHandler implements AuthenticationEventPublisher {

    @Override
    public void publishAuthenticationSuccess(Authentication authentication) {
        if(authentication.getDetails() instanceof WebAuthenticationDetails) return;
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("success login: "+userDetails.getUsername());
    }

    @Override
    public void publishAuthenticationFailure(AuthenticationException e, Authentication authentication) {
        System.out.println("error: "+e.getMessage());
    }
}
