package com.spring.app.bl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.app.bl.dto.UserDto;

@Service("UserService")
public interface UserService {
	public List<UserDto> getAllUser();
	
	public UserDto getUserByid(long id);
	
	public UserDto getUserByUsername(String username);

	public long createUser(UserDto userDto);

	public void updateUser(UserDto userDto);

	public void deleteUser(UserDto userDto);

	public void deleteUserById(long id);
}
