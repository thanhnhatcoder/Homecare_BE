package com.homecare.Homecare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.homecare.Homecare.entity.UserEntity;
import com.homecare.Homecare.repository.UserRepository;


@SpringBootApplication
public class HomecareApplication  {	
	public static void main(String[] args) {
		SpringApplication.run(HomecareApplication.class, args);	
	}

}
