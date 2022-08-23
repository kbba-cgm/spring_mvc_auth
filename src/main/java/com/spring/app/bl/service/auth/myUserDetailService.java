package com.spring.app.bl.service.auth;

import java.beans.JavaBean;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.app.bl.dto.UserDto;
import com.spring.app.bl.dto.auth.AuthUser;
import com.spring.app.bl.service.impl.UserServiceImpl;

public class myUserDetailService implements UserDetailsService {

	@Autowired
	UserServiceImpl userService;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/*
		 * ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		 * roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		 */
		UserDto userDto = userService.getUserByEmail(username);
		if (userDto == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new AuthUser(userDto);
	}

}
