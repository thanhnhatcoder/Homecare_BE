package com.homecare.Homecare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.homecare.Homecare.entity.ComboEntity;
import com.homecare.Homecare.entity.UserEntity;

public interface ComboRepository extends MongoRepository<ComboEntity, String> {
	
}