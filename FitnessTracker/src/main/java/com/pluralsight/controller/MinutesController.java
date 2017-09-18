package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pluralsight.model.Exercise;

@Controller
public class MinutesController {
	
	@RequestMapping("/addMinutes")
	public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {
		
		System.out.println("exercise: " + exercise.getMinutes());
		
		return "addMinutes";
		//return "forward:addMoreMinutes";
		//return "redirect:addMoreMinutes";
	}
	
	
	// Method created to demonstrate chaining of submits
//	@RequestMapping("/addMoreMinutes")
//	public String addMoreMinutes(@ModelAttribute("exercise") Exercise exercise) {
//		
//		System.out.println("exercise: " + exercise.getMinutes());
//		
//		return "addMinutes";
//	}
	
}
