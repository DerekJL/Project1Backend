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
import com.revature.exceptions.ExerciseNotFoundException;
import com.revature.services.ExerciseService;

@RestController						// implies controller and request body on methods
@RequestMapping(value="/exercise")
public class ExerciseController {
	
	static {
		System.out.println("[DEBUG] - ExerciseController instantiated!");
	}
	
	@Autowired
	ExerciseService exerciseService; 
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Exercise> getAll() {
		System.out.println("[DEBUG] - In ExerciseController.getExerciseById");
		return exerciseService.getAllExercises();
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Exercise getExerciseById(@PathVariable int id) {
		System.out.println("[DEBUG] - In ExerciseController.getExerciseById");
		Exercise exercise = exerciseService.getExerciseById(id);
		
		if(exercise == null) {
			throw new ExerciseNotFoundException("Exercise with id " + id + " not found.");
		}
		
		return exercise;
	}
	
	@GetMapping(value="/name", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Exercise getExerciseByName(@RequestBody Exercise ex) {
		System.out.println("[DEBUG] - In ExerciseController.getExerciseByName");
		return exerciseService.getExerciseByName(ex);
	}
	
	@GetMapping(value="/workout", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Exercise getExerciseByWorkout(@RequestBody Exercise ex) {
		System.out.println("[DEBUG] - In ExerciseController.getExerciseByWorkout");
		return exerciseService.getExerciseByWorkout(ex);
	}
	
	@GetMapping(value="/user", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Exercise getExerciseByUserId(@RequestBody int id) {
		System.out.println("[DEBUG] - In ExerciseController.getExerciseByUserId");
		return exerciseService.getExerciseByUserId(id);
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Exercise> createExercise(@RequestBody Exercise ex) {
		System.out.println("[DEBUG] - In ExerciseController.addExercise");
		Exercise exercise = exerciseService.createExercise(ex);
		return new ResponseEntity<Exercise>(exercise, HttpStatus.CREATED);
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Exercise> updateExercise(Exercise ex) {
		System.out.println("[DEBUG] - In ExerciseController.getExerciseByName");
		Exercise exercise = exerciseService.updateExercise(ex);
		
		if(exercise == null) {
			throw new ExerciseNotFoundException("Exercise with id " + ex.getExercise_id() + " not found.");
		}
		
		return new ResponseEntity<Exercise>(HttpStatus.OK);
	}

}
