package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping(value="/user")
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
	
	@GetMapping(value="/username", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserByUsername(@RequestBody User u){
		System.out.println("[DEBUG] - In UserController.getUserByUsername()");
		return userService.getUserByUsername(u);
	}
	
	@PostMapping(value="/login", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User loginUser(@RequestBody User u){
		System.out.println("[DEBUG] - In UserController.getUserByUsername()");
		return userService.getUserByUsername(u);
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserById(@PathVariable int id){
		System.out.println("[DEBUG] - In UserController.getUserById()");
		return userService.getUserById(id);
	}
	
	@GetMapping(value="/email", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserByEmail(@RequestBody User u){
		System.out.println("[DEBUG] - In UserController.getUserByEmail()");
		return userService.getUserByEmail(u);
	}
	
	@PostMapping(value="/register", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User u){
		System.out.println("[DEBUG] - In UserController.addUser()");
		return userService.addUser(u);
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@RequestBody User u){
		System.out.println("[DEBUG] - In UserController.updateUser()");
		return userService.updateUser(u);
	}

}
