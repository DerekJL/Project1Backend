package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;

public interface UserRepository {
	
	public List<User> getAllUsers();
	public User getUserById(int id);
	public User getUserByUsername(User u);
	public User getUserByEmail(User u);
	public User addUser(User newUser);
	public User updateUser(User newUser);

}
