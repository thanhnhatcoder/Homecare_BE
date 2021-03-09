package com.homecare.Homecare.Controller;

import java.util.List;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homecare.Homecare.dto.CustomerDTO;
import com.homecare.Homecare.dto.UserDTO;
import com.homecare.Homecare.entity.UserEntity;
import com.homecare.Homecare.reponse.success.SuccessResponse;
import com.homecare.Homecare.repository.UserRepository;
import com.homecare.Homecare.service.CustomerService;
import com.homecare.Homecare.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

	@Autowired
	private CustomerService customerService ;
@GetMapping("/customer/{id}")
public SuccessResponse<CustomerDTO> findByID(@PathVariable String id) {
	return customerService.findById(id) ;
}
@GetMapping("/customer")
public SuccessResponse<CustomerDTO> findAll() {
	return customerService.findAllUser() ;
}
@PostMapping("/add/customer")
public SuccessResponse addUser(@RequestBody CustomerDTO customerDTO) {
	return this.customerService.save(customerDTO) ;
}
@PutMapping("/{id}/edit/customer")
public SuccessResponse editProfessional(@RequestBody CustomerDTO customerDto) {
    return this.customerService.edit(customerDto);
}
}

