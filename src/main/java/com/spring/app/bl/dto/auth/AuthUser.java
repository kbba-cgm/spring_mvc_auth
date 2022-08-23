package com.spring.app.bl.dto.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.app.bl.dto.UserDto;

public class AuthUser implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDto userDto;
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		return roles;
	}
	
	public AuthUser(UserDto userDto) {
		this.userDto = userDto;
	}
	
	public void updateAuthUser(UserDto userDto) {
		this.userDto = userDto;
	}

	public String getPassword() {
		return userDto.getPassword();
	}
	
	public long getId() {
		return userDto.getId();
	}
	
	public void setId(long id) {
		userDto.setId(userDto.getId());
	}

	public String getUsername() {
		return userDto.getName();
	}
	
	public String getEmail() {
		return userDto.getEmail();
	}
	
	public void setUsername(String username) {
		userDto.setName(username);
	}
	
	
	public void setEmail(String email) {
		userDto.setEmail(email);
	}
	

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
