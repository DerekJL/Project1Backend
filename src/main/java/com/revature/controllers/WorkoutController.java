package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Workout;
import com.revature.exceptions.WorkoutNotFoundException;
import com.revature.services.WorkoutService;

@RestController
@RequestMapping(value="/workouts")
public class WorkoutController {

	static {
		System.out.println("[DEBUG] - WorkoutController instantiated!");
	}
	
	@Autowired
	WorkoutService workoutService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Workout> getAllWorkouts() {
		System.out.println("[DEBUG] - In WorkoutController.getAllWorkouts()");
		return workoutService.getAllWorkouts();
	}
	
	@GetMapping(value="/visibility", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Workout getWorkoutByVisibility(@RequestBody Workout wk) {
		System.out.println("[DEBUG] - In WorkoutController.getWorkoutbyType()");
		return workoutService.getWorkoutByVisibility(wk);
	}
	
	@GetMapping(value="/types", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Workout getWorkoutByType(@RequestBody Workout wk) {
		System.out.println("[DEBUG] - In WorkoutController.getWorkoutbyType()");
		return workoutService.getWorkoutByType(wk);
	}
	
	@GetMapping(value="/names", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Workout getWorkoutByName(@RequestBody Workout wk) {
		System.out.println("[DEBUG] - In WorkoutController.getWorkoutbyName()");
		return workoutService.getWorkoutByName(wk);
	}
	
	@GetMapping(value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Workout getWorkoutById(@PathVariable int id) {
		System.out.println("[DEBUG] - In WorkoutController.getWorkoutbyId()");
		Workout workout = workoutService.getWorkoutById(id);
		
		if(workout == null) {
			throw new WorkoutNotFoundException("Workout with id " + id + " not found.");
		}
		
		return workout;
	}
	
	@GetMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Workout> updateWorkout(@RequestBody Workout wk) {
		System.out.println("[DEBUG]- In WorkoutService.updateWorkout()");
		Workout workout = workoutService.updateWorkout(wk);
		
		if(workout == null) {
			throw new WorkoutNotFoundException("Workout with id " + wk.getWorkout_id() + " not found.");
		}
		
		return new ResponseEntity<Workout>(workout, HttpStatus.OK);
	}
	
	@GetMapping(value="/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Workout> createWorkout(@RequestBody Workout wk) {
		System.out.println("[DEBUG]- In WorkoutService.addWorkout()");
		Workout workout = workoutService.createWorkout(wk);
		return new ResponseEntity<Workout>(workout, HttpStatus.CREATED);
	}
	
	
	
}
