package com.pluralsight.repository;

import com.pluralsight.model.Exercise;

//By default all method inside of an interface are public.
public interface ExerciseRepository {
	
	Exercise save(Exercise exercise);

}
