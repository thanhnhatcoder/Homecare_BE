package com.homecare.Homecare.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.homecare.Homecare.entity.CustomerEntity;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String>{
	  Optional<CustomerEntity> findByEmail(String email);
	  Boolean existsByEmail(String email);
}
