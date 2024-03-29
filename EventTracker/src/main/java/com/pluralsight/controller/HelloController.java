package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/greeting")
	public String sayHello(Model model) {
		model.addAttribute("greeting", "Hello World");
		
		return "hello";
	}
	
	@RequestMapping("/index")
	public String index(Model model) {
		return "forward:index.jsp";
	}
}
