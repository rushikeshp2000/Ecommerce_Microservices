package com.ecommerce.user.service;

import java.util.List;

import com.ecommerce.user.model.AdminResponseResult;
import com.ecommerce.user.model.UserRequest;
import com.ecommerce.user.model.UserResponseResult;

public interface UserService {
	
	UserResponseResult LoginUser(String email,String password);
	
	UserResponseResult saveUser(UserRequest userData);
	
	AdminResponseResult getSeller(String sellerId);
	
	AdminResponseResult deleteSeller(String sellerId);
	
	List<AdminResponseResult> getAllSeller();
	
	AdminResponseResult activeSeller(String sellerId);

}
