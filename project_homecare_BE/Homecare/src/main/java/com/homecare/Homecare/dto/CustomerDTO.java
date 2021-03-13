package com.homecare.Homecare.dto;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
	private String id ;
	private String name ;
	private String phone ;
	private String email ;
	private String gender ;
	private String password ; 
}
