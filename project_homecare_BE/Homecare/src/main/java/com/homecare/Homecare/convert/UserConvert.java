package com.homecare.Homecare.convert;

import org.springframework.stereotype.Component;

import com.homecare.Homecare.dto.UserDTO;
import com.homecare.Homecare.entity.UserEntity;


@Component
public class UserConvert {
	public UserEntity dtoToEntity(UserDTO userDTO) {
	UserEntity userEntity = new UserEntity() ;
	userEntity.setId(userDTO.getId());
	userEntity.setUsername(userDTO.getUsername());
	userEntity.setPassword(userDTO.getPassword());
	return userEntity;
	}
	
	public UserDTO entityToDTO(UserEntity userEntity) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(userEntity.getId());
		userDTO.setUsername(userEntity.getUsername());
		userDTO.setPassword(userEntity.getPassword());
		return userDTO ;
	}

}
