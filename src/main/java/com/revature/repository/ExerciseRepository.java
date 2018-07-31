package com.revature.repository;

import java.util.List;

import com.revature.beans.Exercise;
import com.revature.beans.Workout;


public interface ExerciseRepository {

	public List<Exercise> getAllExercises();
	public Exercise getExerciseById(int id);
	public List<Exercise> getExercisesByName(Exercise ex);
	public List<Exercise> getExercisesByWorkout(Workout wk);
	public Exercise createExercise(Exercise ex);
	public Exercise updateExercise(Exercise ex);
	public List<Exercise> getExercisesByUserId(int id);
}
