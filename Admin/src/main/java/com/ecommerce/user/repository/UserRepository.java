package com.ecommerce.user.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.user.entity.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String>{

	List<UserEntity> findByEmailAndPassword(String email, String password);
}
