package com.spring.app.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.app.persistence.entity.User;

@Repository("UserDao")
public interface UserDao {
	public List<?> getAllUser();
	
	public User getUserByEmail(String email);
	
	public User getUserById(long id);
	
	public User getUserByUsername(String username);
	
	public long createUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);
	
	public void deleteUserById(long id);
}
