package com.springdocker.app.zuul.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private Environment env;


    @Override
    // for the token
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore());
    }

    @Override
    //for the routes
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/api/Oauth/oauth/token").permitAll().
        antMatchers(HttpMethod.GET, "/api/Product/list","/api/Item/list", "/api/User/user").permitAll().
        antMatchers(HttpMethod.GET, "/api/find/{id}", "/api/Item/find/size/{size}", "/api/User/user/{id}").
        hasAnyRole("ADMIN", "MOD").
        antMatchers( "/api/Product/**", "/api/Item/**", "/api/User/**").hasRole("ADMIN").
        anyRequest().authenticated();
    }
    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter(){
        JwtAccessTokenConverter token = new JwtAccessTokenConverter();
        token.setSigningKey(env.getProperty("config.security.oauth.jwt.key"));
        return token;
    }
}
