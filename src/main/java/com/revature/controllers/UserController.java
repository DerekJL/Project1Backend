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
import com.revature.beans.User;
import com.revature.beans.Workout;
import com.revature.exceptions.UserNotFoundException;
import com.revature.services.ExerciseService;
import com.revature.services.UserService;
import com.revature.services.WorkoutService;
import com.revature.util.SendEmailHelper;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	static {
		System.out.println("[DEBUG] - UserController instantiated!");
	}
	
	@Autowired
	UserService userService;
	
	// TESTED WITH POSTMAN SUCCESSFULLY ON 7/31/2018 AT 4:10 P.M.
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers(){
		System.out.println("[DEBUG] - In UserController.getAllUsers()");
		return userService.getAllUsers();
	}
	
	// TESTED WITH POSTMAN SUCCESSFULLY ON 8/01/2018 AT 9:52 A.M.
	@PostMapping(value="/usernames", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserByUsername(@RequestBody User u){
		System.out.println("[DEBUG] - In UserController.getUserByUsername()");
		User user = userService.getUserByUsername(u);
		
//		if(user == null) {
//			throw new UserNotFoundException("User with username " + u.getUsername() + " not found.");
//		}
		return user;
	}
	
	@PostMapping(value="/login", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Boolean loginUser(@RequestBody User u){
		System.out.println("[DEBUG] - In UserController.loginUser()");
		boolean loggedIn = userService.loginUser(u);
		
		if(loggedIn == false) {
				
			//throw new UserNotFoundException("User with username " + u.getUsername() + " not found.");
			return false;
		}
		return true;
	}
	
	// TESTED WITH POSTMAN SUCCESSFULLY ON 8/01/2018 AT 10:13 A.M.
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserById(@PathVariable int id){
		System.out.println("[DEBUG] - In UserController.getUserById()");
		User user = userService.getUserById(id);
		
//		if(user == null) {
//			throw new UserNotFoundException("User with id " + id + " not found.");
//		}
		
		return user;
	}
	
	// TESTED WITH POSTMAN SUCCESSFULLY ON 8/01/2018 AT 9:50 A.M.
	@PostMapping(value="/emails", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserByEmail(@RequestBody User u){
		System.out.println("[DEBUG] - In UserController.getUserByEmail()");
		return userService.getUserByEmail(u);
	}
	
	// TESTED WITH POSTMAN SUCCESSFULLY ON 7/31/2018 AT 4:12 P.M.
	@PostMapping(value="/register", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@RequestBody User u){
		System.out.println("[DEBUG] - In UserController.addUser()");
		User user = userService.addUser(u);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	// TESTED WITH POSTMAN SUCCESSFULLY ON 8/01/2018 AT 10:38 A.M.
	@PutMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User u){
		System.out.println("[DEBUG] - In UserController.updateUser()");
		User user = userService.updateUser(u);
		
//		if(user == null) {
//			throw new UserNotFoundException("User with id " + u.getUser_id() + " not found.");
//		}
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

		@PostMapping(value="/reset", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
		public boolean resetPassword(@RequestBody User u){
			System.out.println("[DEBUG] - In UserController.resetPassword()");
			try {
			SendEmailHelper.sendEmail(u.getEmail());
			}catch(Exception e) {
				return false;
			}
			return true;
		}
}
