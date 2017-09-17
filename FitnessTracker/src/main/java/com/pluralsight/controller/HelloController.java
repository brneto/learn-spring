package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping(value="/")
	public String homePage (Model model) {
		
		model.addAttribute("startMsg", "Fitness Tracker Web Application");
		
		return "index";
	}
	
	@RequestMapping(value="/greeting")
	public String helloPage (Model model) {
		
		model.addAttribute("greeting", "Hello World, Berchris");
		
		return "hello";
	}

}
