package com.homecare.Homecare.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homecare.Homecare.convert.EmployeeConvert;
import com.homecare.Homecare.dto.EmployeeDTO;

import com.homecare.Homecare.entity.EmployeeEntity;

import com.homecare.Homecare.exception.BadRequestException;
import com.homecare.Homecare.exception.NotFoundException;
import com.homecare.Homecare.reponse.success.SuccessResponse;
import com.homecare.Homecare.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository ;
	@Autowired
	private EmployeeConvert employeeConvert ;
	
	@Transactional
	public SuccessResponse edit(EmployeeDTO employeeDTO) {
		if(this.findById(employeeDTO.getId()) == null) throw new NotFoundException("") ;
		{
		Optional<EmployeeEntity> optionalCustomerEntity = employeeRepository.findById(employeeDTO.getId());
		EmployeeEntity employeeEntity = optionalCustomerEntity.orElseThrow(() -> new BadRequestException("ID not correct"));
		employeeEntity.setName(employeeDTO.getName());
		employeeEntity.setPhone(employeeDTO.getPhone());
		employeeEntity.setBirthday(employeeDTO.getBirthday());
		employeeEntity.setCity(employeeDTO.getCity());
		employeeEntity.setDaytowork(employeeDTO.getDaytowork());
		employeeEntity.setDepartment(employeeDTO.getDepartment());
		employeeEntity.setImage(employeeDTO.getImage());
		employeeEntity.setAddress(employeeDTO.getAddress());
		employeeEntity.setGender(employeeDTO.getGender());
		employeeEntity.setEmail(employeeDTO.getEmail());
		employeeConvert.entitytoDTO(employeeRepository.save(employeeEntity));
	}
		return new SuccessResponse();
	}
	@Transactional
	public SuccessResponse save(EmployeeDTO employeeDTO) {
	    EmployeeEntity employeeEntity = new EmployeeEntity();
	    if ( employeeDTO.getName() == null ) {
	        throw new BadRequestException("Invalid input");
	    }
	    else {
	        UUID id = UUID.randomUUID();
	        employeeDTO.setId(id.toString());
	        employeeEntity.setId(employeeDTO.getId());
			employeeEntity.setName(employeeDTO.getName());
			employeeEntity.setPhone(employeeDTO.getPhone());
			employeeEntity.setBirthday(employeeDTO.getBirthday());
			employeeEntity.setCity(employeeDTO.getCity());
			employeeEntity.setDaytowork(employeeDTO.getDaytowork());
			employeeEntity.setDepartment(employeeDTO.getDepartment());
			employeeEntity.setImage(employeeDTO.getImage());
			employeeEntity.setAddress(employeeDTO.getAddress());
			employeeEntity.setGender(employeeDTO.getGender());
			employeeEntity.setEmail(employeeDTO.getEmail());
	        employeeRepository.save(employeeEntity);
	    }
	    SuccessResponse successResponse = new SuccessResponse();
	    successResponse.setCode(201);
	    return successResponse;
	}
	
		public SuccessResponse findById(String idEmployee) {
			Optional<EmployeeEntity> optionalEmployee = employeeRepository.findById(idEmployee);
			if (optionalEmployee.isPresent()) {
				return new SuccessResponse(this.employeeConvert.entitytoDTO(optionalEmployee.get()));
			}
			return new SuccessResponse();
		}
		 public SuccessResponse findAllUser(){
		        SuccessResponse successResponse = new SuccessResponse();
		        successResponse.setData(employeeRepository.findAll());
		        return successResponse;
		    }
	
}
