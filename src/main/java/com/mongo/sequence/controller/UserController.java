package com.mongo.sequence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.sequence.model.User;
import com.mongo.sequence.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getAll() {
		return userService.getAll();
	}

	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		System.out.println("createUser");
		return userService.createUser(user);
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable String id) {
		return userService.getUserById(id);
	}

	@GetMapping("/name/{name}")
	public List<User> getUserByName(@PathVariable String name) {
		return userService.getUserByName(name);
	}

	@GetMapping("/nickname/{username}")
	public List<User> getUserByUserName(@PathVariable String username) {
		return userService.getUserByUserName(username);
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable String id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}

	@DeleteMapping("/{id}")
	public String  deleteUser(@PathVariable String id) {
		 userService.deleteUser(id);
		 return "";
	}

	@DeleteMapping
	public String deleteAllUsers() {
		 userService.deleteAllUsers();
		 return "";
	}

}