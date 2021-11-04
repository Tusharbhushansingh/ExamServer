package com.exam.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.service.UserService;

@Service
public class UserserviceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception  {
		
		User local = this.userRepository.findByUsername(user.getUsername());
		if(local != null) {
			System.out.println("User is already there !!");
			throw new Exception("User already present !!");
		} else {
			// user create
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			local= this.userRepository.save(user);
		}
		return local; 
	}

	//get user by username
	@Override
	public User getByUserName(String username) {
		User user = this.userRepository.findByUsername(username);
		System.out.println(user);
		return user;
	}

	@Override
	public void deleteUser(long id) {
		this.userRepository.deleteById(id);
	}

	@Override
	public User updateUser(User user, String username) throws Exception {
		User user1 = this.userRepository.findByUsername(username);
		if(user1 !=  null) {
			if(user.getFirstName()!=null) {
			user1.setFirstName(user.getFirstName());
			}
			if(user.getLastName()!=null) {
			user1.setLastName(user.getLastName());}
			if(user.getPassword() != null) {
			user1.setPassword(user.getPassword());
			}
			if(user.getEmail()!=null) {
			user1.setEmail(user.getEmail());
			}
			if(user.getPhone()!=null) {
			user1.setPhone(user.getPhone());
			}
			if(user.getProfile()!=null) {
			user1.setProfile(user.getProfile());
			}
			this.userRepository.save(user1);
			return user1;
		}else {
			throw new Exception("username is not exist !!");
		}
	}

}
