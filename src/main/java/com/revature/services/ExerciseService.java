package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Exercise;
import com.revature.beans.Workout;
import com.revature.repository.ExerciseRepository;

@Service
@Transactional
public class ExerciseService {

	static {
		System.out.println("[DEBUG] - ExerciseService has been instantiated!");
	}
	
	@Autowired
	ExerciseRepository exerciseRepo;
	
	public List<Exercise> getAllExercises() {
		System.out.println("[DEBUG] - In ExerciseService.getExerciseById");
		return exerciseRepo.getAllExercises();
	}
	
	public Exercise getExerciseById(int id) {
		System.out.println("[DEBUG] - In ExerciseService.getExerciseById");
		return exerciseRepo.getExerciseById(id);
	}
	
	public List<Exercise> getExercisesByName(Exercise ex) {
		System.out.println("[DEBUG] - In ExerciseService.getExerciseByName");
		return exerciseRepo.getExercisesByName(ex);
	}
	
	public List<Exercise> getExercisesByWorkout(Workout wk) {
		System.out.println("[DEBUG] - In ExerciseService.getExerciseByWorkout");
		return exerciseRepo.getExercisesByWorkout(wk);
	}
	
	public List<Exercise> getExercisesByUserId(int id) {
		System.out.println("[DEBUG] - In ExerciseService.getExerciseByUserId");
		return exerciseRepo.getExercisesByUserId(id);
	}
	
	public Exercise createExercise(Exercise ex) {
		System.out.println("[DEBUG] - In ExerciseService.addExercise");
		return exerciseRepo.createExercise(ex);
	}
	
	public Exercise updateExercise(Exercise ex) {
		System.out.println("[DEBUG] - In ExerciseService.getExerciseByName");
		return exerciseRepo.updateExercise(ex);
	}
}
