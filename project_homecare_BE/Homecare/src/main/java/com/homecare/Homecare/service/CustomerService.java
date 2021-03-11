package com.homecare.Homecare.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homecare.Homecare.convert.CustomerConvert;
import com.homecare.Homecare.dto.CustomerDTO;

import com.homecare.Homecare.entity.CustomerEntity;

import com.homecare.Homecare.exception.BadRequestException;
import com.homecare.Homecare.exception.NotFoundException;
import com.homecare.Homecare.reponse.success.SuccessResponse;
import com.homecare.Homecare.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository ;
	@Autowired
	private CustomerConvert customerConvert ;
	
	@Transactional
	public SuccessResponse edit(CustomerDTO customerDTO) {
		if(this.findById(customerDTO.getId()) == null) throw new NotFoundException("") ;
		{
		Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(customerDTO.getId());
		CustomerEntity customerEntity = optionalCustomerEntity.orElseThrow(() -> new BadRequestException("ID not correct"));
		customerEntity.setId_account(customerDTO.getId_account());
		customerEntity.setPassword(customerDTO.getPassword());
		customerEntity.setName(customerDTO.getName());
		customerEntity.setGender(customerDTO.isGender());
		customerEntity.setEmail(customerDTO.getEmail());
		customerEntity.setPhone(customerDTO.getPhone());
		customerConvert.entitytoDTO(customerRepository.save(customerEntity));
	}
		return new SuccessResponse();
	}
	@Transactional
	public SuccessResponse save(CustomerDTO customerDTO) {
	    CustomerEntity customerEntity = new CustomerEntity();
	    if (customerDTO.getId_account() == null || customerDTO.getPassword() == null ) {
	        throw new BadRequestException("Invalid input");
	    }
	    else {
	        UUID id = UUID.randomUUID();
	        customerDTO.setId(id.toString());
	        customerEntity.setId(customerDTO.getId());
	        customerEntity.setId_account(customerDTO.getId_account());
	        customerEntity.setPassword(customerDTO.getPassword());
	        customerEntity.setName(customerDTO.getName());
	        customerEntity.setEmail(customerDTO.getEmail());
	        customerEntity.setGender(customerDTO.isGender());
	        customerEntity.setPhone(customerDTO.getPhone());
	        customerEntity = customerConvert.dtotoEntity(customerDTO);
	        customerRepository.save(customerEntity);
	    }
	    SuccessResponse successResponse = new SuccessResponse();
	    successResponse.setCode(201);
	    return successResponse;
	}

		public SuccessResponse findById(String idCustomer) {
			Optional<CustomerEntity> optionalCustomer = customerRepository.findById(idCustomer);
			if (optionalCustomer.isPresent()) {
				return new SuccessResponse(this.customerConvert.entitytoDTO(optionalCustomer.get()));
			}
			return new SuccessResponse();
		}
		 public SuccessResponse findAllUser(){
		        SuccessResponse successResponse = new SuccessResponse();
		        successResponse.setData(customerRepository.findAll());
		        return successResponse;
		    }
	
}
