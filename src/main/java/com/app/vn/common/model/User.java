package com.app.vn.common.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "users")
@DynamicInsert
@DynamicUpdate
public class User implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	@Column(name = "login_id" , length = 100, nullable = false, unique = true)
	private String loginId;
	@Column(name = "login_password", length = 500, nullable = false)
	private String loginPassword;
	@Column(length = 500, name = "name_first")
	private String firstName;
	@Column(length = 500, name = "name_last")
	private String lastName;
	@Column(length = 500, name = "nickname")
	private String nickname;
	@Column(length = 500, name = "email", nullable = false, unique = true)
	private String email;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at", length=29)
	private Date createdAt;
	@Column(name="created_by", length=100)
	private String createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at", length=29)
	private Date updatedAt;
	@Column(name="updated_by", length=100)
	private String updatedBy;
	@Column(name="role", length=255)
	private String role;

	public User() {
	}

	public User(String loginId, String loginPassword, String firstName, String lastName, String nickname, String email, Date createdAt, String createdBy, Date updatedAt, String updatedBy) {
		this.loginId = loginId;
		this.loginPassword = loginPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickname = nickname;
		this.email = email;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
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

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return id == user.id &&
				Objects.equals(loginId, user.loginId) &&
				Objects.equals(loginPassword, user.loginPassword) &&
				Objects.equals(firstName, user.firstName) &&
				Objects.equals(lastName, user.lastName) &&
				Objects.equals(nickname, user.nickname) &&
				Objects.equals(email, user.email) &&
				Objects.equals(createdAt, user.createdAt) &&
				Objects.equals(createdBy, user.createdBy) &&
				Objects.equals(updatedAt, user.updatedAt) &&
				Objects.equals(updatedBy, user.updatedBy);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, loginId, loginPassword, firstName, lastName, nickname, email, createdAt, createdBy, updatedAt, updatedBy);
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", loginId='" + loginId + '\'' +
				", loginPassword='" + loginPassword + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", nickname='" + nickname + '\'' +
				", email='" + email + '\'' +
				", createdAt=" + createdAt +
				", createdBy='" + createdBy + '\'' +
				", updatedAt=" + updatedAt +
				", updatedBy='" + updatedBy + '\'' +
				'}';
	}
}
