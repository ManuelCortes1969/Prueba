package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/api") 
public class ControllerApp {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
    	List <User> users = (List<User>) userService.getUsers();
    	return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable("id") UUID id) {
    	Optional<User> user = userService.getUserById(id);
    	if (!user.isEmpty()) {
    	   return new ResponseEntity<>(user, HttpStatus.OK );
    	} else {
     	   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     	}    	   
    }
    
    @PostMapping("/user")
    public ResponseEntity<String> createNewUser(@RequestBody User newuser) {
    	User user = userService.createUser(newuser);
    	if (user != null) {
    	   return new ResponseEntity<>("User created", HttpStatus.OK );
    	} else {
     	   return new ResponseEntity<>("User not created", HttpStatus.BAD_REQUEST);
     	}    	   
    }
    
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String>  deleteUser(@PathVariable("id") UUID id) {
    	Optional<User> user = userService.getUserById(id);
    	if (!user.isEmpty()) {
    	   userService.deleteUserById(id);
     	   return new ResponseEntity<>("User deleted", HttpStatus.OK );
     	} else {
      	   return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
      	}    	      	
    }
    
}