package com.java_mentor.spring_boot.controllers;

import com.java_mentor.spring_boot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;

@Controller
@RequestMapping("/")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping ("/user")
	public String userPage(Model model, Principal principal) {
		model.addAttribute("user", userService.loadUserByUsername(principal.getName()));
		return "user";
	}

}