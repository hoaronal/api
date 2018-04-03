package com.app.vn.common.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id",nullable = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="username")
    private String userName;
    @Column(name="password")
    private String password;
    @Column(name="role")
    private String role;
    @Column(name="full_name")
    private String fullName;
    @Column(name="country")
    private String country;
    @Column(name="enabled")
    private short enabled;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public short getEnabled() {
        return enabled;
    }
    public void setEnabled(short enabled) {
        this.enabled = enabled;
    }
}