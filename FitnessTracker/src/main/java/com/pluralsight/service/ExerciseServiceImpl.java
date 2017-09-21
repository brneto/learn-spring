package com.pluralsight.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pluralsight.model.Activity;

@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {

	@Override
	public List<Activity> findAllActivities() {
		List<Activity> activities = new ArrayList<>();
		
		Activity run = new Activity();
		run.setDesc("Run");
		activities.add(run);
		
		Activity bike = new Activity();
		run.setDesc("Bike");
		activities.add(bike);
		
		Activity swim = new Activity();
		run.setDesc("Swim");
		activities.add(swim);
		
		return activities;
	}
	
}
