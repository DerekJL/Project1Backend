package com.revature.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.UserExercise;
import com.revature.helpers.UserExerciseHelper;


@RestController
@RequestMapping(value="/user-exercises")
public class UserExerciseController {
	
	@PostMapping(value="/exercise")
	public boolean guideWorkout(@RequestBody UserExercise userExercise) {
		System.out.println("In UserExercise/guideWorkout");
		try {
		UserExerciseHelper.sendMessage(userExercise);
		}catch (Exception e) {
			return false;
		}
		
		return true;	
	}
	
	
	@PostMapping(value="/rest")
	public boolean guideRest(@RequestBody UserExercise userExercise) {
		System.out.println("In UserExercise/guideWorkout");
		
		try {
		UserExerciseHelper.sendRest(userExercise);
		}catch (Exception e) {
			return false;
		}
		
		return true;
		
		
	}

}
