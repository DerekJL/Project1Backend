package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Exercise;


public interface ExerciseRepository {

	public List<Exercise> getAllExercises();
	public Exercise getExerciseById(int id);
	public List<Exercise> getExercisesByName(Exercise ex);
	public Exercise getExerciseByWorkout(Exercise ex);
	public Exercise createExercise(Exercise ex);
	public Exercise updateExercise(Exercise ex);
	public Exercise getExerciseByUserId(int id);
}
