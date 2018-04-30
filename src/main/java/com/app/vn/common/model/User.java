package com.app.vn.common.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users")
@DynamicInsert
@DynamicUpdate
public class User extends DomainObject<Long> implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "login_id" , length = 100, nullable = false, unique = true)
    private String loginId;
    @Column(name = "login_password", length = 500, nullable = false)
    private String loginPassword;
    @Column(length = 50, name = "name_first", nullable = false)
    private String firstName;
    @Column(length = 50, name = "name_last", nullable = false)
    private String lastName;
    @Column(length = 500, name = "nickname")
    private String nickname;
    @Column(length = 200, name = "email", nullable = false, unique = true)
    private String email;
    @Column(length = 255, name = "role")
    private String role;
    @Column(name = "description")
    private String description;

    /*@Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at", length=29)
    private Date createdAt;
    @Column(name="created_by", length=100)
    private String createdBy;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at", length=29)
    private Date updatedAt;
    @Column(name="updated_by", length=100)
    private String updatedBy;*/

    public User() {
    }

    public User(String loginId, String loginPassword, String firstName, String lastName, String nickname, String email, String role, String description) {
        this.loginId = loginId;
        this.loginPassword = loginPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.email = email;
        this.role = role;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
