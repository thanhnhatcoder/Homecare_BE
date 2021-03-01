package com.homecare.Homecare.Controller;

import java.util.List;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homecare.Homecare.dto.UserDTO;
import com.homecare.Homecare.entity.UserEntity;
import com.homecare.Homecare.reponse.success.SuccessResponse;
import com.homecare.Homecare.repository.UserRepository;
import com.homecare.Homecare.service.UserService;



@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService userService ;
@GetMapping("/user/{id}")
public SuccessResponse<UserDTO> findByID(@PathVariable String id) {
	return userService.findById(id) ;
}
@GetMapping("/user")
public SuccessResponse<UserDTO> findAll() {
	return userService.findAllUser() ;
}
@PostMapping("/add/user")
public SuccessResponse addUser(@RequestBody UserDTO userDTO) {
	return this.userService.save(userDTO) ;
}

}

