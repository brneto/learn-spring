package com.pluralsight.repository;

import com.pluralsight.model.Goal;

//By default all method inside of an interface are public.
public interface GoalRepository {
	
	Goal save(Goal goal);

}
