package com.homecare.Homecare.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.SuccessCallback;

import com.homecare.Homecare.convert.UserConvert;
import com.homecare.Homecare.dto.UserDTO;
import com.homecare.Homecare.entity.UserEntity;
import com.homecare.Homecare.exception.BadRequestException;
import com.homecare.Homecare.exception.NotFoundException;
import com.homecare.Homecare.reponse.success.SuccessResponse;
import com.homecare.Homecare.repository.UserRepository;



@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserConvert UserConvert;

@Transactional
public SuccessResponse edit(UserDTO userDTO) {
	if(this.findById(userDTO.getId()) == null) throw new NotFoundException("") ;
	{
	Optional<UserEntity> optionalUserEntity = userRepository.findById(userDTO.getId());
	UserEntity userEntity = optionalUserEntity.orElseThrow(() -> new BadRequestException("ID not correct"));
	userEntity.setUsername(userDTO.getUsername());
	userEntity.setPassword(userDTO.getPassword());
	UserConvert.entityToDTO(userRepository.save(userEntity));
}
	return new SuccessResponse();
}
@Transactional
public SuccessResponse save(UserDTO userDTO) {
    UserEntity userEntity = new UserEntity();
    if (userDTO.getUsername() == null || userDTO.getPassword() == null ) {
        throw new BadRequestException("Invalid input");
    }
    else {
        UUID id = UUID.randomUUID();
        userDTO.setId(id.toString());
        userEntity.setId(userDTO.getId());
        userEntity = UserConvert.dtoToEntity(userDTO);
        userRepository.save(userEntity);
    }
    SuccessResponse successResponse = new SuccessResponse();
    successResponse.setCode(201);
    return successResponse;
}

	public SuccessResponse findById(String idUser) {
		Optional<UserEntity> optionalUser = userRepository.findById(idUser);
		if (optionalUser.isPresent()) {
			return new SuccessResponse(this.UserConvert.entityToDTO(optionalUser.get()));
		}
		return new SuccessResponse();
	}
	 public SuccessResponse findAllUser(){
	        SuccessResponse successResponse = new SuccessResponse();
	        successResponse.setData(userRepository.findAll());
	        return successResponse;
	    }
}
