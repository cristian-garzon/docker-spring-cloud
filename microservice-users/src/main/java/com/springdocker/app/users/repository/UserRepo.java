package com.springdocker.app.users.repository;

import com.springdocker.app.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "user")
public interface UserRepo extends JpaRepository<User, Long> {
    public User findByUser(String user);
}
