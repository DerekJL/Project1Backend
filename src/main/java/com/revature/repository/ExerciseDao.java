package com.revature.repository;

import java.util.ArrayList;

import com.revature.models.Exercise;


public interface ExerciseDao {

	public ArrayList<Exercise> getAllExercises();
	public Exercise getExerciseByVisibility();
	public Exercise getExerciseByType();
	public boolean createExercise();
}
