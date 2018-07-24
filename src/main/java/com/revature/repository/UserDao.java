package com.revature.repository;

import java.util.ArrayList;

import com.revature.models.User;

public interface UserDao {
	
	public ArrayList<User> getAllUsers();
	public User getUserByUsername();
	public User getUserByEmail();
	public boolean addUser();

}
