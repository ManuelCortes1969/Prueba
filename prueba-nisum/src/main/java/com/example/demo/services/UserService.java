package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import com.example.demo.Users1Application;
import com.example.demo.entities.Phone;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	private final UserRepository userRepository;  
	
	public UserService (UserRepository userRepository, Users1Application users1Application) {
		this.userRepository = userRepository;
	}

	public List<User> getUsers() { 
		List<User> users = (List<User>) userRepository.findAll();
		return users;
	}  
		
	public Optional<User> getUserById(UUID id) { 
	    Optional<User> user = userRepository.findById(id);
	    return user;
	} 

	@Transactional
	public User createUser(User newuser) { 	
		User user = new User();
		user.setName(newuser.getName());
		user.setEmail(newuser.getEmail());
		user.setPassword(newuser.getPassword());
		for (Phone phone:newuser.getPhones()) {
			phone.setUser(user);
			user.getPhones().add(phone);
		}
		user = userRepository.save(user);
		return user;
	} 

	public void deleteUserById(UUID id) { 
	    userRepository.deleteById(id);
	} 
}
