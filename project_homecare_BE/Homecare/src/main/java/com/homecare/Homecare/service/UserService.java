package com.homecare.Homecare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homecare.Homecare.convert.BrandConvert;
import com.homecare.Homecare.convert.UserConvert;
import com.homecare.Homecare.reponse.success.SuccessResponse;
import com.homecare.Homecare.repository.BrandRepository;
import com.homecare.Homecare.repository.UserDetailRepository;
import com.homecare.Homecare.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserDetailRepository userRepository;
	@Autowired
	private UserConvert userConvert;

	public SuccessResponse findAllUser() {
		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setData(userRepository.findAll());
		return successResponse;
	}
}
