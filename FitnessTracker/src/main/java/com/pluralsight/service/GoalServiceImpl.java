package com.pluralsight.service;

import org.springframework.stereotype.Service;

import com.pluralsight.model.Goal;

@Service("goalService")
public class GoalServiceImpl implements GoalService {

	@Override
	public Goal save(Goal goal) {
		return null;
	}

}
