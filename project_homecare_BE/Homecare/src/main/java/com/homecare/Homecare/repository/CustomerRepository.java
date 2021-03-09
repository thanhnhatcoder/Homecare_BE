package com.homecare.Homecare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.homecare.Homecare.entity.CustomerEntity;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String>{
}
