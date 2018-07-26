package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Workout;

public interface WorkoutRepository {
 
	public List<Workout> getAllWorkouts();
	public Workout getWorkoutByVisibility(Workout wk);
	public Workout getWorkoutById(int id);
	public List<Workout> getWorkoutsByUserId(Workout wk);	
	public Workout getWorkoutByType(Workout wk);
	public Workout getWorkoutByName(Workout wk);
	public Workout createWorkout(Workout new_wk); 
	public Workout updateWorkout(Workout wk);
}
