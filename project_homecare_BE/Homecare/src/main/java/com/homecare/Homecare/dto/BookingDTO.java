package com.homecare.Homecare.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookingDTO {
	private String id ;
	private String address ;
	private String brand ;
	private Date date ;
	private String description ;
	private String district ;
	private String email ;
	private String fullname ;
	private String phone ;
	private String product ;
	private String province ;
	private String service ;
}
