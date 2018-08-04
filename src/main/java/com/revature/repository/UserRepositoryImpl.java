package com.revature.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;

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
		String hql = "from User u WHERE u.username = ?";
		Query query = s.createQuery(hql).setParameter(0, u.getUsername());
		User user = new User();
		
		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			
		}
		
//		if (user == null) {
//			return null;
//		} 
		
		return user;
	}

	public User getUserByEmail(User u) {
		System.out.println("[DEBUG] - UserRepository.getUserByEmail()");
		Session s = sessionFactory.getCurrentSession();
		String hql = "from User u WHERE u.email = ?";
		Query query = s.createQuery(hql).setParameter(0, u.getEmail());
		User user = new User();
		
		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			
		}
			
//		if (user == null) {
//			return null;
//		} 
		
		return user;
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
		//System.out.println(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
		newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
		//System.out.println(newUser.getPassword());
		s.save(newUser);
		return newUser;
		
	}

	@Override
	public User updateUser(User currentUser) {
		System.out.println("[DEBUG] - In UserRepository.updateUser()");
		Session s = sessionFactory.getCurrentSession();
		currentUser.setPassword(BCrypt.hashpw(currentUser.getPassword(), BCrypt.gensalt()));

		User user = s.get(User.class, currentUser.getUser_id());
		
		if(user == null) {
			return user;
		}		
		
		user.setUser_id(currentUser.getUser_id());
		user.setUsername(currentUser.getUsername());
		user.setPassword(currentUser.getPassword());
		user.setFirstName(currentUser.getFirstName());
		user.setLastName(currentUser.getLastName());
		user.setEmail(currentUser.getEmail());
		user.setPhone(currentUser.getPhone());
		
		return user;
	}
	
	@Override
	 public boolean loginUser(User u) {
	        System.out.println("[DEBUG] - UserRepository.getUserByEmail()");
	        Session s = sessionFactory.getCurrentSession();
	        String hql = "from User u WHERE u.username = ?";
	        Query query = s.createQuery(hql);
	        query.setParameter(0, u.getUsername());

	        User user = new User();
	        
	        try {
	            user = (User) query.getSingleResult();
	            if(BCrypt.checkpw(u.getPassword(), user.getPassword())) {
	                return true;
	            }
	            else {
	                return false;
	            }
	        } catch (Exception e) {
	            return false;
	        }        
	    }

}
