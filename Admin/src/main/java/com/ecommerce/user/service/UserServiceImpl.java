package com.ecommerce.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.user.entity.UserEntity;
import com.ecommerce.user.exception.InvalidUser;
import com.ecommerce.user.mapper.MapStructMapper;
import com.ecommerce.user.model.UserRequest;
import com.ecommerce.user.model.UserResponseResult;
import com.ecommerce.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	MapStructMapper mapper;
	
	@Autowired
	UserRepository repository;

	@Override
	public UserResponseResult saveUser(UserRequest userData) {
		UserEntity entityUser = mapper.entityToRequest(userData);
		UserEntity save = repository.save(entityUser);
		UserResponseResult response = mapper.responseToEntity(save);
		return response;
	}

	@Override
	public UserResponseResult LoginUser(String email, String password) {
		List<UserEntity> findByEmailAndPassword = repository.findByEmailAndPassword(email, password);
		if(findByEmailAndPassword.isEmpty())
		{
			throw new InvalidUser("You have not registered in system");
		}
		UserEntity entity = findByEmailAndPassword.get(0);
		UserResponseResult response = mapper.responseToEntity(entity);
		return response;
	}

}
