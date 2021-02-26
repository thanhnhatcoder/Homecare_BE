package com.homecare.Homecare.repository;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.homecare.Homecare.entity.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String> {
	 UserEntity findByUsername(String username);
}
