package com.homecare.Homecare.dto;

import java.util.Date;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
	private String id ;
	private String name ;
	private String phone ;
	private String email ;
	private String address ;
	private String city ;
	private String department ;
	private Date birthday;
	private Date daytowork;
	private String gender ;
	private String image ;
}
