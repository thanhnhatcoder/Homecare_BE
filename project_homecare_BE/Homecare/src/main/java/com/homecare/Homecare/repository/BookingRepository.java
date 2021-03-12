package com.homecare.Homecare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.homecare.Homecare.entity.BookingEntity;

public interface BookingRepository extends MongoRepository<BookingEntity, String> {

}
