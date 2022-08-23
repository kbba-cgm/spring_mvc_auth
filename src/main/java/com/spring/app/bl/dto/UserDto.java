package com.spring.app.bl.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.spring.app.persistence.entity.User;

public class UserDto {
	private long id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	@Email
	@Column(unique = true)
	private String email;
	
	@Length(min = 6, message = "Password must be at least 6 chars")
	@NotEmpty(message = "Password must not be empty")
	private String password;
	
	private Timestamp created_at;
	
	private Timestamp updated_at;
	
	public UserDto() {
		super();
	}
	
	public UserDto(User user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.created_at = user.getCreated_at();
		this.updated_at = user.getUpdated_at();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
}
