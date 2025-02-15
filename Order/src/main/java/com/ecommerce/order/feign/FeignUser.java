package com.ecommerce.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USERSERVICE")
public interface FeignUser {

	 @GetMapping("/user/{UserId}")
	 ResponseEntity<User> getUser(@PathVariable("UserId") String UserId);
	

}
