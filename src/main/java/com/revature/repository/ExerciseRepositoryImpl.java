package com.revature.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.Exercise;

@Repository
public class ExerciseRepositoryImpl implements ExerciseRepository{
	
	static {
		System.out.println("[DEBUG] - ExerciseRepository instantiated!");
	}
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Exercise> getAllExercises() {
		System.out.println("[DEBUG] - ExerciseRepository instantiated!");
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from Exercise", Exercise.class).getResultList();
	}

	@Override
	public Exercise getExerciseById(int id) {
		System.out.println("[DEBUG] - In ExerciseRepositoryImpl.getExerciseById");
		Session s = sessionFactory.getCurrentSession();
		return s.get(Exercise.class, id);
		
	}

	@Override
	public List<Exercise> getExercisesByName(Exercise ex) {
		System.out.println("[DEBUG] - In ExerciseRepositoryImpl.getExerciseByName");
		Session s = sessionFactory.getCurrentSession();
		String hql = "from Exercise e WHERE e.name = ?";
		Query query = s.createQuery(hql).setParameter(0, ex.getExercise_name());
		List<Exercise> exercise = query.getResultList();
		return exercise;
	}

	@Override
	public Exercise getExerciseByWorkout(Exercise ex) {
		System.out.println("[DEBUG] - In ExerciseRepositoryImpl.getExerciseByWorkout");
		Session s = sessionFactory.getCurrentSession();
		return s.get(Exercise.class, ex.getExercise_id());
	}
	
	@Override
	public Exercise getExerciseByUserId(int id) {
		System.out.println("[DEBUG] - In ExerciseRepositoryImpl.getExerciseByUserId");
		Session s = sessionFactory.getCurrentSession();
		return s.get(Exercise.class, id);
	}

	@Override
	public Exercise createExercise(Exercise new_ex) {
		System.out.println("[DEBUG] - In ExerciseRepositoryImpl.createExercise");
		Session s = sessionFactory.getCurrentSession();
		s.save(new_ex);
		return new_ex;
	}

	@Override
	public Exercise updateExercise(Exercise ex) {
		System.out.println("[DEBUG] - In ExerciseRepositoryImpl.updateExercise");
		Session s = sessionFactory.getCurrentSession();
		Exercise temp = s.get(Exercise.class, ex.getExercise_id());
			
		if(temp == null) {
			return temp;
		}
		
		temp = ex;
		return temp;
	}

	

}
