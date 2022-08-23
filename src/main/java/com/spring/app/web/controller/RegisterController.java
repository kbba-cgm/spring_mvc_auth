package com.spring.app.web.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.app.bl.dto.UserDto;
import com.spring.app.bl.dto.auth.AuthUser;
import com.spring.app.bl.service.UserService;

@Controller
public class RegisterController {
	@Autowired
	UserService userService;
	
	@Autowired
	BCryptPasswordEncoder encoder;

	@GetMapping(value = { "/register" })
	public String registerPage(ModelMap m) {
		UserDto userDto = new UserDto();
		m.addAttribute(userDto);
		return "register";
	}

	@PostMapping(value = { "/register" })
	public String register(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult br) {
		if (br.hasErrors())
			return "register";

		ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		userDto.setPassword(encoder.encode(userDto.getPassword()));
		long new_id = userService.createUser(userDto);
		userDto.setId(new_id);
		Authentication auth = new UsernamePasswordAuthenticationToken(new AuthUser(userDto), null, roles);
		SecurityContextHolder.getContext().setAuthentication(auth);
		return "redirect:/";

	}

}
