package com.spring.app.bl.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.bl.dto.UserDto;
import com.spring.app.bl.service.UserService;
import com.spring.app.persistence.dao.UserDao;
import com.spring.app.persistence.entity.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	
	private Timestamp now = new Timestamp(new Date().getTime());
	
	@SuppressWarnings("unchecked")
	public List<UserDto> getAllUser() {
		return (List<UserDto>) userDao.getAllUser();
	}
	
	public UserDto getUserByUsername(String username) {
		return new UserDto(userDao.getUserByUsername(username));
	}
	
	public UserDto getUserByEmail(String email) {
		return new UserDto(userDao.getUserByEmail(email));
	}
	
	public UserDto getUserByid(long id) {
		return new UserDto(userDao.getUserById(id));
	}

	public long createUser(UserDto userDto) {
		userDto.setCreated_at(now);
		userDto.setUpdated_at(now);
		return userDao.createUser(getUserData(userDto));
	}

	public void updateUser(UserDto userDto) {
		userDto.setUpdated_at(now);
		userDao.updateUser(getUserData(userDto));
	}

	public void deleteUser(UserDto userDto) {
		userDao.deleteUser(getUserData(userDto));
	}

	public void deleteUserById(long id) {
		userDao.deleteUserById(id);
	}
	
	public boolean isUserExist(UserDto userDto) {
		return userDao.getUserById(userDto.getId()) != null;
	}
	
	public User getUserData(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setCreated_at(userDto.getCreated_at());
		user.setUpdated_at(userDto.getUpdated_at());
		return user;
	}

}
