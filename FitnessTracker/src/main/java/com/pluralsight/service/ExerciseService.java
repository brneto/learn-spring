package com.pluralsight.service;

import java.util.List;


import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;

//By default all method inside of an interface are public.
public interface ExerciseService {

	List<Activity> findAllActivities();

	Exercise save(Exercise exercise);

}