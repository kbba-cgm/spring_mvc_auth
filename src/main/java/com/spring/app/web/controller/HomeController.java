package com.spring.app.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.app.bl.dto.UserDto;
import com.spring.app.bl.dto.auth.AuthUser;
import com.spring.app.bl.service.UserService;

@Controller
public class HomeController {
	@Autowired
	UserService userService;
	
	@Autowired
	BCryptPasswordEncoder encoder;

	@GetMapping("/")
	public String homeView() {
		return "home";
	}

	@GetMapping("/lists")
	public String listView() {
		return "list";
	}

	@GetMapping("/edit/{user_id}")
	public String editView(@PathVariable("user_id") long id, ModelMap m) {
		UserDto userDto = userService.getUserByid(id);
		System.out.println(userDto.getCreated_at());
		if (userDto.getName() == null) {
			System.out.println("error page");
			return null;
		} else {
			m.addAttribute("userDto", userDto);
			return "edit";
		}
	}

	@RequestMapping(value = { "/update" }, method = RequestMethod.POST)
	public String updateUser(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult errors,
			@AuthenticationPrincipal AuthUser authUser) {
		if (errors.hasErrors()) {
			return "edit";
		} else {
			userDto.setPassword(encoder.encode(userDto.getPassword()));
			userService.updateUser(userDto);
			authUser.updateAuthUser(userDto);

			return "redirect:/";
		}
	}
}
