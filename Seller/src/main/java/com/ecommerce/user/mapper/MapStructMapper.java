package com.ecommerce.user.mapper;

import org.mapstruct.Mapper;

import com.ecommerce.user.entity.UserEntity;
import com.ecommerce.user.model.UserRequest;
import com.ecommerce.user.model.UserResponseResult;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
	
	UserRequest requestToEntity(UserEntity entity);
	UserEntity entityToRequest(UserRequest request);
	
	UserResponseResult responseToEntity(UserEntity entity);
	UserEntity entityToResponse(UserResponseResult response);
	
	

}
