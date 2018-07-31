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

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	static {
		System.out.println("[DEBUG] - UserController instantiated!");
	}
	
	@Autowired
	UserService userService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers(){
		System.out.println("[DEBUG] - In UserController.getAllUsers()");
		return userService.getAllUsers();
	}
	
	@PostMapping(value="/usernames", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserByUsername(@RequestBody User u){
		System.out.println("[DEBUG] - In UserController.getUserByUsername()");
		User user = userService.getUserByUsername(u);
		
		if(user == null) {
			throw new UserNotFoundException("User with username " + u.getUsername() + " not found.");
		}
		return user;
	}
	
	@PostMapping(value="/login", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User loginUser(@RequestBody User u){
		System.out.println("[DEBUG] - In UserController.loginUser()");
		User user = userService.getUserByUsername(u);
		
		if(user == null) {
			throw new UserNotFoundException("User with username " + u.getUsername() + " not found.");
		}
		return user;
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserById(@PathVariable int id){
		System.out.println("[DEBUG] - In UserController.getUserById()");
		User user = userService.getUserById(id);
		
		if(user == null) {
			throw new UserNotFoundException("User with id " + id + " not found.");
		}
		
		return user;
	}
	
	
	@PostMapping(value="/emails", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserByEmail(@RequestBody User u){
		System.out.println("[DEBUG] - In UserController.getUserByEmail()");
		return userService.getUserByEmail(u);
	}
	
	@PostMapping(value="/register", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@RequestBody User u){
		System.out.println("[DEBUG] - In UserController.addUser()");
		User user = userService.addUser(u);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User u){
		System.out.println("[DEBUG] - In UserController.updateUser()");
		User user = userService.updateUser(u);
		
		if(user == null) {
			throw new UserNotFoundException("User with id " + u.getUser_id() + " not found.");
		}
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
