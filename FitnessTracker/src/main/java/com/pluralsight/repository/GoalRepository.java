package com.pluralsight.repository;

import java.util.List;

import com.pluralsight.model.Goal;

//By default all method inside of an interface are public.
public interface GoalRepository {
	
	Goal save(Goal goal);

	List<Goal> loalAll();

}
