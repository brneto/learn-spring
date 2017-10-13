package com.pluralsight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pluralsight.model.Goal;
import com.pluralsight.repository.GoalRepository;

@Service("goalService")
public class GoalServiceImpl implements GoalService {

	@Autowired
	private GoalRepository goalRepository;
	
	@Transactional
	@Override
	public Goal save(Goal goal) {
		return goalRepository.save(goal);
	}

	@Override
	public List<Goal> findAllGoals() {
		return goalRepository.loalAll();
	}

}
