package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/")
	public String homePage () {
		
		return "index";
	}
	
	@RequestMapping("/greeting")
	public String helloPage (Model model) {
		
		model.addAttribute("greeting", "Hello World, Berchris");
		
		return "hello";
	}

}
