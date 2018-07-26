package com.revature.repository;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.Workout;

public class WorkoutRepositoryImpl implements WorkoutRepository{
	
	static {
		System.out.println("[DEBUG] - In WorkoutRepositoryImpl");
	}
	
	@Autowired
	SessionFactory sessionFactory; 

	@Override
	public List<Workout> getAllWorkouts() {
		System.out.println("[DEBUG] - In WorkoutRepositoryImpl.getAllWorkouts");
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from Workout", Workout.class).getResultList();
	}

	@Override
	public Workout getWorkoutByVisibility(Workout wk) {
		System.out.println("[DEBUG] - In WorkoutRepositoryImpl.getWorkoutsByVisibility");
		Session s = sessionFactory.getCurrentSession();
		return s.get(Workout.class, wk.getWorkout_visibility());
	}

	@Override
	public Workout getWorkoutByType(Workout wk) {
		System.out.println("[DEBUG] - In WorkoutRepositoryImpl.getWorkoutsByType");
		Session s = sessionFactory.getCurrentSession();
		return s.get(Workout.class, wk.getType_id());
	}

	@Override
	public Workout getWorkoutByName(Workout wk) {
		System.out.println("[DEBUG] - In WorkoutRepositoryImpl.getgetWorkoutsByName");
		Session s = sessionFactory.getCurrentSession();
		return s.get(Workout.class, wk.getWorkout_name());
	}

	@Override
	public Workout updateWorkout(Workout wk) {
		System.out.println("[DEBUG] - In WorkoutRepositoryImpl.getgetWorkoutsByName");
		Session s = sessionFactory.getCurrentSession();
		Workout temp = s.get(Workout.class, wk.getWorkout_id());
		temp = wk;
		return temp;
	}

	@Override
	public Workout getWorkoutById(int id) {
		System.out.println("[DEBUG] - In WorkoutRepositoryImpl.getgetWorkoutsByName");
		Session s = sessionFactory.getCurrentSession();
		return s.get(Workout.class, id);
	}

	@Override
	public Workout createWorkout(Workout new_wk) {
		System.out.println("[DEBUG] - In WorkoutRepositoryImpl.getgetWorkoutsByName");
		Session s = sessionFactory.getCurrentSession();
		s.save(new_wk);
		return new_wk;
	}

	@Override
	public List<Workout> getWorkoutsByUserId(Workout wk) {
		ArrayList<Workout> workouts = new ArrayList<>(); 
		System.out.println("[DEBUG] - In WorkoutRepositoryImpl.getgetWorkoutsByName");
		Session s = sessionFactory.getCurrentSession();
		Query query = (Query) s.createQuery("from Workout w where w.user_id = ? ").getResultList();
		query.setParameter(0, wk.getUser_id());
		workouts = (ArrayList<Workout>) query.list();
		return workouts;		
	}

	

}
