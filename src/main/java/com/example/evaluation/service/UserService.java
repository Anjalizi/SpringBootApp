package com.example.evaluation.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.evaluation.model.Person;
import com.example.evaluation.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<Person> getAllUsers() {
		List<Person> list = new ArrayList<>();
		// CrudRepository provides the findAll() function to get all entities
		// use that to populate the list
		// list::add is lambda expression to add each element in the list
		userRepository.findAll().forEach(list::add);
		return list;
	}

	public Person getUserById(int id) throws Exception {
		boolean userExists = userRepository.existsById(id);
		if (userExists) {
			return userRepository.findById(id).get();
		} else {
			throw new Exception("User not found");
		}
	}

	public void addUser(Person user) {
		userRepository.save(user);
	}

	public void deleteUser(int id) throws Exception {
		boolean userExists = userRepository.existsById(id);
		if (userExists) {
			userRepository.deleteById(id);
		} else {
			throw new Exception("User not found so cannot be deleted");
		}
	}

	public void updateUser(Person updatedUser, int id) throws Exception {
		boolean userExists = userRepository.existsById(id);
		if (userExists) {
			if (id == updatedUser.getId()) {
				userRepository.save(updatedUser);
			} else {
				throw new Exception("Primary key cannot be changed.");
			}
		} else {
			throw new Exception("User not found so cannot be updated");
		}
	}
}
