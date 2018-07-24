package com.revature.repository;

import java.util.ArrayList;

import com.revature.models.Workout;

public interface WorkoutDao {

	public ArrayList<Workout> getAllWorkouts();
	public Workout getWorkoutByVisibility();
	public Workout getWorkoutByType();
	public boolean createWorkout();
}
