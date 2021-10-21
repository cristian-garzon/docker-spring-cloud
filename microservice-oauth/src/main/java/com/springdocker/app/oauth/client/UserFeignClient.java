package com.springdocker.app.oauth.client;

import com.springdocker.cammons.user.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "microservice-user")
public interface UserFeignClient {
    @GetMapping("/user/search/find")
    public User findByUsername(@RequestParam(name = "username") String username);

    @PutMapping("/user/{id}")
    public User update(@RequestBody User user, @PathVariable Long id);

}
