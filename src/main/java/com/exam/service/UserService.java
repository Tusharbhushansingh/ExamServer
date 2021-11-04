package com.exam.service;

import java.util.Set;

import com.exam.models.User;
import com.exam.models.UserRole;

public interface UserService {

	//creating user
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	//retrieve user by username
	public User getByUserName(String username);
	
	//delete by id
	public void deleteUser(long id);
	
	//update user by username
	public User updateUser(User user, String username) throws Exception;
}
