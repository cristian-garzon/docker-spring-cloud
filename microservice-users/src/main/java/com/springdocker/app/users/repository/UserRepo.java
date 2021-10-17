package com.springdocker.app.users.repository;

import com.springdocker.cammons.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "user")
public interface UserRepo extends JpaRepository<User, Long> {
    @RestResource(path = "find")
    public User findByUsername(@Param("username") String username);
}
