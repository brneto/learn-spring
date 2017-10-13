package com.pluralsight.repository;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pluralsight.model.Goal;

@Repository("goalRepository")
public class GoalRepositoryImpl implements GoalRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Goal save(Goal goal) {
		
		em.persist(goal);
		em.flush();
		
		return goal;
	}

	@Override
	public List<Goal> loalAll() {
		Query query = em.createQuery("Select g from Goal g");
		
		@SuppressWarnings("unchecked")
		List<Goal> goals = Collections.checkedList(query.getResultList(), Goal.class);
		
		return goals;
	}

}
