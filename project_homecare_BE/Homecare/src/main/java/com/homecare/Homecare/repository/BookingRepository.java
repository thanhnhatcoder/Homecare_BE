package com.homecare.Homecare.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.homecare.Homecare.entity.BookingEntity;

public interface BookingRepository extends MongoRepository<BookingEntity, String> {

	@Query("{'email' : ?0}")
	Optional<BookingEntity> findBookingByEmail(String email);
}
