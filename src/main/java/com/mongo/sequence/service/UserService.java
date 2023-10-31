package com.mongo.sequence.service;

import java.util.List;

import com.mongo.sequence.model.User;

public interface UserService {

	User createUser(User user);

	List<User> getAll();

	User getUserById(String id);

	List<User> getUserByName(String name);

	User updateUser(String id, User user);

	void deleteUser(String id);

	void deleteAllUsers();

	List<User> getUserByUserName(String username);

}