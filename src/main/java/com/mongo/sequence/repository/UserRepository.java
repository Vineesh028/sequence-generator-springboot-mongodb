package com.mongo.sequence.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.sequence.model.User;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByName(String name);
	List<User> findByUserName(String username);
}