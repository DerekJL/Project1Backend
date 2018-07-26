package com.revature.controllers;

import com.revature.models.User;
import com.revature.repository.UserRepositoryImpl;

public class TestDriver {

	public static void main(String[] args) {
		
		User newUser = new User(1, "jbein", "pass", "John", "Beineke", "jbein@gmail.com", "317-956-0842");
		
		UserRepositoryImpl userRepo = new UserRepositoryImpl();
		
		System.out.println(userRepo.addUser(newUser));
		
		

	}

}
