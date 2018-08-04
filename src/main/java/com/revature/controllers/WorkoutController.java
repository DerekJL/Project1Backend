package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Exercise;
import com.revature.beans.Workout;
import com.revature.beans.WorkoutExercise;
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
	
	@GetMapping(value="/visibility/{num}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Workout> getWorkoutsByVisibility(@PathVariable int num) {
		System.out.println("[DEBUG] - In WorkoutController.getWorkoutbyType()");
		return workoutService.getWorkoutByVisibility(num);
	}
	
//	@GetMapping(value="/types/{num}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
//	public Workout getWorkoutByType(@PathVariable int num) {
//		System.out.println("[DEBUG] - In WorkoutController.getWorkoutbyType()");
//		return workoutService.getWorkoutByType(wk);
//	}
//	
//	@PostMapping(value="/names", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
//	public Workout getWorkoutByName(@RequestBody Workout wk) {
//		System.out.println("[DEBUG] - In WorkoutController.getWorkoutbyName()");
//		return workoutService.getWorkoutByName(wk);
//	}
	
	@GetMapping(value="/users/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Workout> getWorkoutsByUserId(@PathVariable int id) {
		System.out.println("[DEBUG] - In ExerciseController.getExerciseByUserId");
		return workoutService.getWorkoutsByUserId(id);
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
	
	@PutMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Workout> updateWorkout(@RequestBody Workout wk) {
		System.out.println("[DEBUG]- In WorkoutService.updateWorkout()");
		Workout workout = workoutService.updateWorkout(wk);
		
		if(workout == null) {
			throw new WorkoutNotFoundException("Workout with id " + wk.getWorkout_id() + " not found.");
		}
		
		return new ResponseEntity<Workout>(workout, HttpStatus.OK);
	}
	
	@PostMapping(value="/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Workout> createWorkout(@RequestBody Workout wk) {
		System.out.println("[DEBUG]- In WorkoutService.createWorkout()");
		System.out.println(wk);
		Workout workout = workoutService.createWorkout(wk);
		return new ResponseEntity<Workout>(workout, HttpStatus.CREATED);
	}
	 
	@PostMapping(value="/createjunction", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkoutExercise> createWorkoutExercise(@RequestBody WorkoutExercise wk) {
        System.out.println("[DEBUG]- In WorkoutController.createWorkoutExercise()");
        System.out.println(wk);
        System.out.println("this exercises workout id while in the controller: "+ wk.getWorkout_id());
        WorkoutExercise workoutExercise = workoutService.createWorkoutExercise(wk);
        return new ResponseEntity<WorkoutExercise>(workoutExercise, HttpStatus.CREATED);
    } 
	
}
