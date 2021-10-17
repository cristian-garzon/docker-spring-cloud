package com.springdocker.app.oauth.service;

import com.springdocker.cammons.user.entity.User;

public interface IuserService {
    public User findUser(String username);
}
