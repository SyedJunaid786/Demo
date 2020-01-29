package com.webencyclop.demo.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.webencyclop.demo.model.Role;
import com.webencyclop.demo.model.User;
import com.webencyclop.demo.repository.RoleRepository;
import com.webencyclop.demo.repository.UserRepository;

@Service
public class UserServiceImp implements UserService 
{
	
	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public void saveUser(User user)
	{
		user.setPassword(encoder.encode(user.getPassword()));
		user.setStatus("VERIFIED");
		Role userRole = roleRepository.findByRole("SITE_USER");
	    user.setRoles(new HashSet<Role>(Arrays.asList(userRole))); 
		userRepository.save(user);
	}

	@Override
	public boolean isUserAlreadyPresent(User user) 
	{
		// Try to implement this method, as assignment.
		System.out.println("First Name-" + " " + user.getName());
		System.out.println("LastName-" + " " +user.getLastName());
		System.out.println("Email-"  + " " +user.getEmail());
		System.out.println("Password-"  + " " +user.getPassword());
			
		boolean userr=userRepository.existsById(user.getId());
		System.out.println(userr);
	
		if(userr)
		{
			System.out.println("Same Id");
		}
		else
		{
			System.out.println("Different Id");
		}
		
		if(userRepository.findByEmail(user.getEmail()) != null) 
		{
			return true;
		}
		else
		{
			return false;
		}
	       
	}
}
