package com.homecare.Homecare.convert;

import org.springframework.stereotype.Component;

import com.homecare.Homecare.dto.ComboDTO;
import com.homecare.Homecare.dto.CustomerDTO;
import com.homecare.Homecare.entity.ComboEntity;
import com.homecare.Homecare.entity.CustomerEntity;

@Component
public class CustomerConvert {
	public CustomerEntity dtotoEntity(CustomerDTO customerDTO) {
		CustomerEntity customerEntity = new CustomerEntity() ;
		customerEntity.setId(customerDTO.getId());
		customerEntity.setName(customerDTO.getName());
		customerEntity.setPhone(customerDTO.getPhone());
		customerEntity.setPassword(customerDTO.getPassword());
		customerEntity.setGender(customerDTO.getGender());
		customerEntity.setEmail(customerDTO.getEmail());
		return customerEntity ;
	}
	public CustomerDTO entitytoDTO(CustomerEntity customerEntity) {
		CustomerDTO customerDTO = new CustomerDTO() ;
		customerDTO.setId(customerEntity.getId());
		customerDTO.setPassword(customerEntity.getPassword());
		customerDTO.setPhone(customerEntity.getPhone());
		customerDTO.setGender(customerEntity.getGender());
		customerDTO.setEmail(customerEntity.getEmail());
		return customerDTO ;
	}
}