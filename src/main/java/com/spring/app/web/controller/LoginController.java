package com.spring.app.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.app.bl.dto.UserDto;

@Controller
public class LoginController {
	@GetMapping(value = { "/login" })
	public String loginPage(ModelMap m) {
		UserDto userDto = new UserDto();
		m.addAttribute(userDto);
		return "login";
	}

	@PostMapping(value = "/login")
	public String loginAction(@Valid @ModelAttribute("UserDto") UserDto userDto,
			@RequestParam(value = "error", required = false) String error, ModelMap model,
			BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result.getErrorCount());
		}
		return null;
	}
	
}
