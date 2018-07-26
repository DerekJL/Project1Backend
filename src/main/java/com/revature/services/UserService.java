package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;
import com.revature.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	static {
		System.out.println("[DEBUG] - FlashCardService instantiated!");
		
	}
	
	@Autowired
	UserRepository userRepo;
	
	
	public List<User> getAllUsers(){
		System.out.println("[DEBUG] - In UserService.getAllUsers()");
		return userRepo.getAllUsers();
	}
	
	public User getUserById(int id) {
		System.out.println("[DEBUG] - In UserService.getUserById()");
		return userRepo.getUserById(id);
	}
	
	public User getUserByEmail(User u) {
		System.out.println("[DEBUG] - In UserService.getUserByEmail()");
		return userRepo.getUserByEmail(u);
	}
	
	public User getUserByUsername(User u) {
		System.out.println("[DEBUG] - In UserService.getUserByUsername()");
		return userRepo.getUserByUsername(u);
	}
	
	public User addUser(User u) {
		System.out.println("[DEBUG] - In UserService.addUser()");
		return userRepo.addUser(u);
	}
	
	public User updateUser(User u) {
		System.out.println("[DEBUG] - In UserService.updateUser()");
		return userRepo.updateUser(u);
	}

	

}
