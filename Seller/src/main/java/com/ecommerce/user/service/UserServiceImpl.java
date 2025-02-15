package com.ecommerce.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.user.entity.Status;
import com.ecommerce.user.entity.UserEntity;
import com.ecommerce.user.exception.InvalidUser;
import com.ecommerce.user.mapper.MapStructMapper;
import com.ecommerce.user.model.AdminResponseResult;
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
		entityUser.setStatus(Status.ACTIVE);
		System.out.println(entityUser);
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
		if(Status.INACTIVE.equals(entity.getStatus()) )
		{
			throw new InvalidUser("Admin has removed you");
		}
		UserResponseResult response = mapper.responseToEntity(entity);
		response.setSellerid(entity.getId());
		System.out.println(response);
		return response;
	}

	@Override
	public AdminResponseResult getSeller(String sellerId) {
		Optional<UserEntity> findById = repository.findById(sellerId);
		if(findById.isEmpty())
		{
			throw new InvalidUser(" user not present in system");
		}
		UserEntity userEntity = findById.get();
		AdminResponseResult admin = new AdminResponseResult();
		admin.setId(userEntity.getId());
		admin.setName(userEntity.getName());
		admin.setEmail(userEntity.getEmail());
		admin.setAddress(userEntity.getAddress());
		admin.setPhone(userEntity.getPhone());
		admin.setPhone(userEntity.getPhone());
		admin.setStatus(userEntity.getStatus().toString());
		return admin;
	}

	@Override
	public AdminResponseResult deleteSeller(String sellerId) {
		Optional<UserEntity> findById = repository.findById(sellerId);
		if(findById.isEmpty())
		{
			throw new InvalidUser(" user not present in system");
		}
		UserEntity userEntity = findById.get();
		userEntity.setStatus(Status.INACTIVE);
		UserEntity save = repository.save(userEntity);
		AdminResponseResult admin = new AdminResponseResult();
		admin.setId(save.getId());
		admin.setName(save.getName());
		admin.setEmail(save.getEmail());
		admin.setAddress(save.getAddress());
		admin.setPhone(save.getPhone());
		admin.setPhone(save.getPhone());
		admin.setStatus(save.getStatus().toString());
		
		return admin;
	}

	@Override
	public List<AdminResponseResult> getAllSeller() {
		List<AdminResponseResult> resultlist = new ArrayList<>();
		List<UserEntity> findAll = repository.findAll();
		for(UserEntity entity : findAll)
		{
		    AdminResponseResult result = new AdminResponseResult();
		    result.setId(entity.getId());
		    result.setName(entity.getName());
		    result.setEmail(entity.getEmail());
		    result.setAddress(entity.getAddress());
		    result.setPhone(entity.getPhone());
		    result.setStatus(entity.getStatus().toString());
		    resultlist.add(result);
		}
		return resultlist;
	}

	@Override
	public AdminResponseResult activeSeller(String sellerId) {
		Optional<UserEntity> findById = repository.findById(sellerId);
		if(findById.isEmpty())
		{
			throw new InvalidUser(" user not present in system");
		}
		UserEntity userEntity = findById.get();
		userEntity.setStatus(Status.ACTIVE);
		UserEntity save = repository.save(userEntity);
		AdminResponseResult admin = new AdminResponseResult();
		admin.setId(save.getId());
		admin.setName(save.getName());
		admin.setEmail(save.getEmail());
		admin.setAddress(save.getAddress());
		admin.setPhone(save.getPhone());
		admin.setPhone(save.getPhone());
		admin.setStatus(save.getStatus().toString());
		
		return admin;
	}

}
