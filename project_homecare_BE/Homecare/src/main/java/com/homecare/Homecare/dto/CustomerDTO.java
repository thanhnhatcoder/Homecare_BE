package com.homecare.Homecare.dto;

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
	private String address ;
	private boolean gender ;
	private String id_account ;
	private String password ; 
}
