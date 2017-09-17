package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MinutesController {
	
	@RequestMapping("/addMinutes")
	public String addMinutes() {
		return "addMinutes";
	}
	
}
