package com.homecare.Homecare.entity;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Customer {
	private String id ;
	private String name ;
	private String phone ;
	private String address ;
	private boolean gender ;
	private String id_account ;
	private String password ;
}
