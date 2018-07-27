package com.revature.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.beans.Workout;

@Repository
public interface WorkoutRepository {
 
	public List<Workout> getAllWorkouts();
	public List<Workout> getWorkoutsByVisibility(String visibility);
	public Workout getWorkoutById(int id);
	public List<Workout> getWorkoutsByUserId(Workout wk);	
//	public Workout getWorkoutByType(Workout wk);
//	public Workout getWorkoutByName(Workout wk);
	public Workout createWorkout(Workout new_wk); 
	public Workout updateWorkout(Workout wk);
	public Workout updateQueuedFlag(Workout wk);
}
