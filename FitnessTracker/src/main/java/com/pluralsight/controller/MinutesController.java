package com.pluralsight.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;
import com.pluralsight.service.ExerciseService;

@Controller
public class MinutesController {
	
	@Autowired
	private ExerciseService exerciseService;
	
	@GetMapping("/addMinutes")
	public String getMinutes(@ModelAttribute ("exercise") Exercise exercise) {
	
		return "addMinutes";
	}
	
	@PostMapping("/addMinutes")
	public String addMinutes(@Valid @ModelAttribute("exercise") Exercise exercise, BindingResult result) {
		
		System.out.println("exercise: " + exercise.getMinutes());
		System.out.println("exercise activity: " + exercise.getActivity());
		
		if(result.hasErrors()) {
			return "addMinutes";
		}
		
		return "addMinutes";
		//return "forward:addMoreMinutes";
		//return "redirect:addMoreMinutes";
	}
	
	@GetMapping("/activities")
	public @ResponseBody List<Activity> findAllActivities() {
		return exerciseService.findAllActivities();
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
