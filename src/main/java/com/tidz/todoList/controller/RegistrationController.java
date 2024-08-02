package com.tidz.todoList.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tidz.todoList.entity.User;
import com.tidz.todoList.repository.UserRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping
	public String showRegistrationForm() {
		return "register";
	}

	@PostMapping
	public String registerUser(@RequestParam String username, @RequestParam String password) {
		User user = new User(username, password, Collections.singletonList("ROLE_USER"));
		this.userRepo.save(user);
		return "redirect:/login";
	}
}
