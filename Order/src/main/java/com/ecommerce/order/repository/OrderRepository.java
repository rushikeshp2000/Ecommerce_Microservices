package com.ecommerce.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.order.entity.OrderEntity;

@Repository
public interface OrderRepository extends MongoRepository<OrderEntity,String>{

}
