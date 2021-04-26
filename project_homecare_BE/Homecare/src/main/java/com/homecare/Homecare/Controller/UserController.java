package com.homecare.Homecare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homecare.Homecare.dto.ProductDTO;
import com.homecare.Homecare.dto.UserDTO;
import com.homecare.Homecare.reponse.success.SuccessResponse;
import com.homecare.Homecare.service.ProductService;
import com.homecare.Homecare.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
@Autowired
private UserService userService ;

@GetMapping("/user")
public SuccessResponse<UserDTO> findAll(){
	System.out.println("HELLOSsssssssssssssssss");
	return userService.findAllUser();
}
}
