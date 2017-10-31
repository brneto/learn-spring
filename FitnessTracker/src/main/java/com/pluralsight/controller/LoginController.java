package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(ModelMap model) {
		System.out.println("In the login method.");
		
		return "login";
	}
	
	@GetMapping(value = "/login", params = "error")
	public String loginFailed(ModelMap model) {
		System.out.println("Login Failed!");
		
		model.addAttribute("error", true);
		return "login";
	}
	
	@GetMapping(value = "/login", params = "logout")
	public String logout(ModelMap model) {
		System.out.println("In the logout method.");
		
		return "logout";
	}
	
	@GetMapping("/denied")
	public String denied(ModelMap model) {
		System.out.println("In the denied method.");
		
		return "denied";
	}
}
