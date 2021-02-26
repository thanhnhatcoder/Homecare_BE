package com.homecare.Homecare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.homecare.Homecare.entity.Combo;
import com.homecare.Homecare.entity.UserEntity;

public interface ComboRepository extends MongoRepository<Combo, String> {
	
}