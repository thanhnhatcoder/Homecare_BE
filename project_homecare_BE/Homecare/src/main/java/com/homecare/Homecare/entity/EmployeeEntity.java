package com.homecare.Homecare.entity;

import java.util.Date;
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
@Document(collection = "employee")
public class EmployeeEntity {
	@Id
	private String id ;
	@NotBlank
	private String name ;
	@NotBlank
	private String phone ;
	@NotBlank
	private String email ;
	@NotBlank
	private String province ;
	@NotBlank
	private String city ;
	@NotBlank
	private String department ;
	@NotBlank
	private Date birthday;
	@NotBlank
	private Date daytowork;
	@NotBlank
	private String gender ;
	@NotBlank
	private String image ;
}

