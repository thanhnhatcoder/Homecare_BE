package com.homecare.Homecare.entity;



import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer")
public class UserEntity {

	@Id
	private String id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 120)
	private String password;

	public UserEntity(@NotBlank String username, @NotBlank String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
}
