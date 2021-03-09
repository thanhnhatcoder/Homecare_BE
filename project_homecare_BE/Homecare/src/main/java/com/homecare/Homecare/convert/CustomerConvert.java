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
		customerEntity.setId_account(customerDTO.getId_account());
		customerEntity.setPassword(customerDTO.getPassword());
		customerEntity.setGender(customerDTO.isGender());
		customerEntity.setEmail(customerDTO.getEmail());
		return customerEntity ;
	}
	public CustomerDTO entitytoDTO(CustomerEntity customerEntity) {
		CustomerDTO customerDTO = new CustomerDTO() ;
		customerDTO.setId(customerEntity.getId());
		customerDTO.setName(customerEntity.getName());
		customerDTO.setId_account(customerEntity.getId_account());
		customerDTO.setPassword(customerEntity.getPassword());
		customerDTO.setPhone(customerEntity.getPhone());
		customerDTO.setGender(customerEntity.isGender());
		customerDTO.setEmail(customerEntity.getEmail());
		return customerDTO ;
	}
}