package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.models.Role;
import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.service.UserService;

@SpringBootApplication
public class ExamServerApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting code");
		
		/*
		 * User user = new User();
		 * 
		 * user.setFirstName("Tushar"); user.setLastName("Kumar");
		 * user.setUsername("txkuar"); user.setPassword("abc");
		 * user.setEmail("abc@gmail.com"); user.setProfile("default.png");
		 * 
		 * Role role = new Role(); role.setRoleId(44L); role.setRoleName("ADMIN");
		 * 
		 * Set<UserRole> userRoleSet = new HashSet<>(); UserRole userRole = new
		 * UserRole(); userRole.setRole(role); userRole.setUser(user);
		 * 
		 * userRoleSet.add(userRole);
		 * 
		 * try { User user1 = this.userService.createUser(user, userRoleSet);
		 * System.out.println(user1.getUsername()); } catch (Throwable e) {
		 * e.printStackTrace(); }
		 */
				
	}

}
