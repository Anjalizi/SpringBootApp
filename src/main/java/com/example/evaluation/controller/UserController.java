package com.example.evaluation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.evaluation.model.Person;
import com.example.evaluation.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<Person> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public Person getUserById(@PathVariable int id) throws Exception {
		return userService.getUserById(id);
	}
	
	@PostMapping("/users")
	public void addUser(@RequestBody Person user) {
		userService.addUser(user);
	}
	
	@PutMapping("/users/{id}")
	public String updateUser(@RequestBody Person user, @PathVariable int id) throws Exception {
		userService.updateUser(user, id);
		return "User details have been updated";
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable int id) throws Exception {
		userService.deleteUser(id);
		return "User has been deleted";
	}
}
