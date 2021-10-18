package com.springdocker.app.oauth.client;

import com.springdocker.cammons.user.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "microservice-user")
public interface UserFeignClient {
    @GetMapping("/user/search/find")
    public User findByUsername(@RequestParam(name = "username") String username);
}