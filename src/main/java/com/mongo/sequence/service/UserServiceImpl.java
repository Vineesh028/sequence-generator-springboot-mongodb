package com.mongo.sequence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.sequence.model.User;
import com.mongo.sequence.repository.UserRepository;
import com.mongo.sequence.util.SequenceGeneratorService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	@Override
	public User createUser(User user) {

		user.setUserName(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
		return repository.save(user);
	}

	@Override
	public List<User> getAll() {

		return repository.findAll();
	}

	@Override
	public User getUserById(String id) {

		return repository.findById(id).get();
	}

	@Override
	public List<User> getUserByName(String name) {

		return repository.findByName(name);
	}

	@Override
	public User updateUser(String id, User user) {
		User existingUser = repository.findById(id).get();
		existingUser.setName(user.getName());
		existingUser.setUserName(user.getUserName());
		existingUser.setEmail(user.getEmail());
		return repository.save(existingUser);

	}

	@Override
	public void deleteUser(String id) {

		repository.deleteById(id);

	}

	@Override
	public void deleteAllUsers() {
		repository.deleteAll();
	}

	@Override
	public List<User> getUserByUserName(String username) {
		return repository.findByUserName(username);
	}
}