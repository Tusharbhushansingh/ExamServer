package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.models.Role;
import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.service.UserService;
import com.exam.service.impl.UserserviceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	//creating user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		Set<UserRole> roles = new HashSet<>();
		
		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		
		roles.add(userRole);
		User u1 = this.userService.createUser(user, roles);
		System.out.println(u1);
		return u1;
	}
	
	//get user by username
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String userName) {
		return this.userService.getByUserName(userName);
	}
	
	//delete user by id
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		this.userService.deleteUser(id);
	}
	
	//update user by username
	@PutMapping("/{username}")
	public User updateUser(@RequestBody User user, @PathVariable("username") String username) throws Exception {
		return this.userService.updateUser(user,username);
	}
}
 