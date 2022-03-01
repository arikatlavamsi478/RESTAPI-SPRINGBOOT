package com.spring.rest.webservices.springbootrestfulservices.User;

import java.util.ArrayList;

/*@autowired
private User;*/

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	public static  ArrayList<User> users = new ArrayList<>();
	
	private static int usersCount = 3;
	
	static {
	
		users.add(new User(1, "Vamsi", new Date()));
		users.add(new User(2, "Dada11", new Date()));
		users.add(new User(3, "Virat", new Date()));
		
	}

	// private static int usersCount = 3;
	
	// find all users
	public ArrayList<User> findAll()
	{
		return users;
	}
	
	// save user
	public User save(User user) 
	{
		
		  if(user.getId() == null) {
			//  int usersCount = 3;
			user.setId(++usersCount ); 
			}
		 
		users.add(user);
		return user;
	}
	
	//find user by id
	
	public User findOne(int id){
		for(User user:users)
		{
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
		}

}
