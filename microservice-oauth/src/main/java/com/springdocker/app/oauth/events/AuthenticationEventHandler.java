package com.springdocker.app.oauth.events;

import brave.Tracer;
import com.springdocker.app.oauth.service.IuserService;
import com.springdocker.cammons.user.entity.User;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEventHandler implements AuthenticationEventPublisher {

    @Autowired
    private IuserService service;

    @Autowired
    private Tracer tracer;

    @Override
    public void publishAuthenticationSuccess(Authentication authentication) {
        if(authentication.getDetails() instanceof WebAuthenticationDetails) return;
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("success login: "+userDetails.getUsername());
        User user = service.findUser(authentication.getName());
        if( user.getLogin() != null && user.getLogin() > 0 ){
            user.setLogin(0);
            service.update(user, user.getId());
        }
    }

    @Override
    public void publishAuthenticationFailure(AuthenticationException e, Authentication authentication) {
        System.out.println("error: "+e.getMessage());
       try {
           StringBuilder error = new StringBuilder();
           error.append("error: "+e.getMessage());
           User user = service.findUser(authentication.getName());
           if (user.getLogin() == null) user.setLogin(0);
           user.setLogin(user.getLogin() + 1);
           error.append(" -  try: " + user.getLogin());
           if(user.getLogin() >= 3){
               user.setEnabled(false);
               user.setLogin(0);
               System.out.println("the user "+ user.getUsername() + "has been blocked");
               error.append(" -  the user "+ user.getUsername() + "has been blocked");
           }
           service.update(user, user.getId());
           error.append("try : " + user.getLogin());
           tracer.currentSpan().tag("error.user.blocked", error.toString());
       } catch (FeignException exceptiona){
           System.out.println("user not exist: "+authentication.getName());
       }

    }
}
