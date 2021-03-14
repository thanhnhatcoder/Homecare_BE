package com.homecare.Homecare.entity;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
	@Email
	private String email;
	
	@NotBlank
	private String gender;
	
	@NotBlank
	private String password;
	
	@DBRef
	  private Set<Role> roles = new HashSet<>();
}
