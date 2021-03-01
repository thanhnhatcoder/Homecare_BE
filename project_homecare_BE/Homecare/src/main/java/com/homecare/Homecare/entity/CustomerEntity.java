package com.homecare.Homecare.entity;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@Document(collection = "customer")
public class CustomerEntity {
	@Id
	private String id;
	@NotBlank
	private String name;
	
	@NotBlank
	private String phone;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private boolean gender;
	
	@NotBlank
	private String id_account;
	
	@NotBlank
	private String password;
}
