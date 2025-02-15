package com.ecommerce.user.service;

import com.ecommerce.user.model.User;
import com.ecommerce.user.model.UserRequest;
import com.ecommerce.user.model.UserResponseResult;

public interface UserService {
	
	User LoginUser(String email,String password);
	
	UserResponseResult saveUser(UserRequest userData);
	
	User getUser(String userId);

}
