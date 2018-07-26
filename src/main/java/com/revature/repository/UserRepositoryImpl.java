package com.revature.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
	static {
		System.out.println("[DEBUG] - UserRepository instantiated!");
	}
	
	@Autowired
	SessionFactory sessionFactory;

	public List<User> getAllUsers() {
		System.out.println("[DEBUG] - in UserRepository.getAllUsers()");
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from User", User.class).getResultList();
	}

	public User getUserByUsername(User u) {
		System.out.println("[DEBUG] - UserRepository.getUserByEmail()");
		Session s = sessionFactory.getCurrentSession();
		return s.get(User.class, u.getUsername());
	}

	public User getUserByEmail(User u) {
		System.out.println("[DEBUG] - UserRepository.getUserByEmail()");
		Session s = sessionFactory.getCurrentSession();
		return s.get(User.class, u.getEmail());
	}


	@Override
	public User getUserById(int id) {
		System.out.println("[DEBUG] - UserRepository.getById()");
		Session s = sessionFactory.getCurrentSession();
		return s.get(User.class, id);
	}

	@Override
	public User addUser(User newUser) {
		System.out.println("[DEBUG] - UserRepository.addUser()");
		Session s = sessionFactory.getCurrentSession();
		s.save(newUser);
		return newUser;
		
	}

	@Override
	public User updateUser(User newUser) {
		System.out.println("[DEBUG] - UserRepository.getById()");
		Session s = sessionFactory.getCurrentSession();
		User u = s.get(User.class, newUser.getUser_id());
		u = newUser;
		return u;
	}

}
