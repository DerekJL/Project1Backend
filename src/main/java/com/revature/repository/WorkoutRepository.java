package com.revature.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.beans.Workout;
import com.revature.beans.WorkoutExercise;

@Repository
public interface WorkoutRepository {
 
	public List<Workout> getAllWorkouts();
	public List<Workout> getWorkoutsByVisibility(int visibilityId);
	public Workout getWorkoutById(int id);
	public List<Workout> getWorkoutsByUserId(int id);	
//	public Workout getWorkoutByType(Workout wk);
//	public Workout getWorkoutByName(Workout wk);
	public Workout createWorkout(Workout new_wk); 
	public Workout updateWorkout(Workout wk);
	public Workout updateQueuedFlag(Workout wk);
	public WorkoutExercise createWorkoutExercise(WorkoutExercise wk_ex);
}
