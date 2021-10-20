package com.springdocker.cammons.user.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean enabled;

    @Column(length = 60)
    private String password;

    @Column(length = 30, unique = true)
    private String username;
    private String name;
    private String surname;

    @Column(unique = true)
    private String email;

    public void setLogin(int login) {
        this.login = login;
    }

    public int getLogin() {
        return login;
    }

    @Transient
    private int login;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id_user"),
                inverseJoinColumns = @JoinColumn(name = "id_role"),
    uniqueConstraints = {@UniqueConstraint(columnNames = {"id_user","id_role"})})
    private List<Role> roles;

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
