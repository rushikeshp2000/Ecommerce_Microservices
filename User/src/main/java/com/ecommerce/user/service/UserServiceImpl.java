package com.ecommerce.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.user.entity.UserEntity;
import com.ecommerce.user.exception.InvalidUser;
import com.ecommerce.user.mapper.MapStructMapper;
import com.ecommerce.user.model.User;
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
		UserResponseResult response = mapper.responseToEntity(entityUser);
		return response;
	}

	@Override
	public User LoginUser(String email, String password) {
		List<UserEntity> findByEmailAndPassword = repository.findByEmailAndPassword(email, password);
		if(findByEmailAndPassword.isEmpty())
		{
			throw new InvalidUser("You have not registered in system");
		}
		UserEntity entity = findByEmailAndPassword.get(0);
		User user = new User();
		user.setId(entity.getId());
		user.setName(entity.getName());
		user.setAddress(entity.getAddress());
		user.setEmail(entity.getEmail());
		user.setPhone(entity.getPhone());
		
		return user;
		
	}

	@Override
	public User getUser(String userId) {
		Optional<UserEntity> findById = repository.findById(userId);
		System.out.println(findById);
		if(findById.isEmpty())
		{
			throw new InvalidUser("You have not registered in system");
		}
		UserEntity userEntity = findById.get();
		System.out.println(userEntity);
		User user = new User();
		user.setId(userId);
		user.setName(userEntity.getName());
		user.setAddress(userEntity.getAddress());
		user.setEmail(userEntity.getEmail());
		user.setPhone(userEntity.getPhone());
		
		return user;
		
	}

}
