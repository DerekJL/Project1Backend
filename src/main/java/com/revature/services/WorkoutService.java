package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Workout;
import com.revature.repository.WorkoutRepository;

@Service 
@Transactional
public class WorkoutService {
	
	static {
		System.out.println("[DEBUG] - WorkoutService instantiated!");
		
	}
	
	@Autowired
	WorkoutRepository workoutRepo;
	
	public List<Workout> getAllWorkouts(){
		System.out.println("[DEBUG]- In WorkoutService.getAllWorkouts()");
		return workoutRepo.getAllWorkouts();
	}
	
	public List<Workout> getWorkoutByVisibility(int visibilityId) {
		System.out.println("[DEBUG]- In WorkoutService.getWorkoutByVisibility()");
		return workoutRepo.getWorkoutsByVisibility(visibilityId);
	}
	
//	public Workout getWorkoutByType(Workout wk) {
//		System.out.println("[DEBUG]- In WorkoutService.getworkoutByType()");
//		return workoutRepo.getWorkoutByType(wk);
//	}
	
//	public Workout getWorkoutByName(Workout wk) {
//		System.out.println("[DEBUG]- In WorkoutService.getWorkoutByName()");
//		return workoutRepo.getWorkoutByName(wk);
//	}
	
	public Workout getWorkoutById(int id) {
		System.out.println("[DEBUG]- In WorkoutService.getWorkoutById()");
		return workoutRepo.getWorkoutById(id);
	}

	public Workout updateWorkout(Workout wk) {
		System.out.println("[DEBUG]- In WorkoutService.updateWorkout()");
		return workoutRepo.updateWorkout(wk);
	}
	
	public Workout createWorkout(Workout wk) {
		System.out.println("[DEBUG]- In WorkoutService.addWorkout()");
		return workoutRepo.createWorkout(wk);
	}
	
	public List<Workout> getWorkoutsByUserId(int id){
		System.out.println("[DEBUG]- In WorkoutService.getWorkoutsByUserId()");
		return workoutRepo.getWorkoutsByUserId(id);
	}
		
}
