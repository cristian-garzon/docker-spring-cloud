package com.springdocker.app.oauth.security;

import com.springdocker.app.oauth.service.IuserService;
import com.springdocker.cammons.user.entity.User;
import feign.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAddToken implements TokenEnhancer {

    @Autowired
    private IuserService userService;


    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String, Object> newInfo = new HashMap<>();
        User user = userService.findUser(oAuth2Authentication.getName());
        newInfo.put("name", user.getName());
        newInfo.put("surname", user.getSurname());
        newInfo.put("email", user.getEmail());
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(newInfo);
        return oAuth2AccessToken;
    }
}
