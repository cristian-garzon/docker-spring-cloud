package com.springdocker.app.oauth.service;

import com.springdocker.app.oauth.client.UserFeignClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Qualifier("userService")
public class UserService implements UserDetailsService,IuserService {

    @Autowired
    private UserFeignClient client;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            com.springdocker.cammons.user.entity.User user = client.findByUsername(s);
            List<GrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
            return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
        }catch (FeignException exception){
            System.out.println("error: " + exception.getMessage());
            throw new UsernameNotFoundException("user dont found");
        }
    }

    @Override
    public com.springdocker.cammons.user.entity.User findUser(String username) {
        return client.findByUsername(username);
    }

    @Override
    public com.springdocker.cammons.user.entity.User update(com.springdocker.cammons.user.entity.User user, Long id) {
        return client.update(user, id);
    }
}
