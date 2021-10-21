package com.springdocker.app.oauth.events;

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
           User user = service.findUser(authentication.getName());
           if (user.getLogin() == null) user.setLogin(0);
           user.setLogin(user.getLogin() + 1);
           if(user.getLogin() >= 3){
               user.setEnabled(false);
               user.setLogin(0);
               System.out.println("the user "+ user.getUsername() + "has been blocked");
           }
           service.update(user, user.getId());
           System.out.println("try: " + user.getLogin());
       } catch (FeignException exceptiona){
           System.out.println("user not exist: "+authentication.getName());
       }

    }
}
