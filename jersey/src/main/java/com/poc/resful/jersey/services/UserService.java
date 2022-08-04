package com.poc.resful.jersey.services;


import com.poc.resful.jersey.dao.UserDao;
import com.poc.resful.jersey.entities.User;


public class UserService {
     
    UserDao userDao = new UserDao();
	
	public void addUser(User user) {
		userDao.addUser(user);
		System.out.println("============");
		return ;
	}
	
	
	

}
