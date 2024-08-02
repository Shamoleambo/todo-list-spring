package com.tidz.todoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.tidz.todoList.service.TodoService;

@Controller
public class HomeController {

	@Autowired
	private TodoService todoService;

	@GetMapping("/")
	public String viewHomePage(@AuthenticationPrincipal UserDetails userDetails) {
		return "todos";
	}

	@GetMapping("/user")
	public String userInfo(@AuthenticationPrincipal UserDetails userDetails) {
		return "Username: " + userDetails.getUsername();
	}
}
