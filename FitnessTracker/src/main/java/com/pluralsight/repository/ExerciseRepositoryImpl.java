package com.pluralsight.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pluralsight.model.Exercise;

@Repository("exerciseRepository")
public class ExerciseRepositoryImpl implements ExerciseRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Exercise save(Exercise exercise) {
		
		if(exercise.getId() == null) {
			em.persist(exercise);
			
			em.flush();
		}
		else {
			exercise = em.merge(exercise);
		}
		
		return exercise;
	}

}
