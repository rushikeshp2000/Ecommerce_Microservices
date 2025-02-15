package com.ecommerce.cart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.cart.Dto.ImageDTO;
import com.ecommerce.cart.Dto.ProductDTO;
import com.ecommerce.cart.Dto.ProductResponse;
import com.ecommerce.cart.entity.CartEntity;
import com.ecommerce.cart.feign.ProductFeign;
import com.ecommerce.cart.model.CartResponse;
import com.ecommerce.cart.model.ImageModel;
import com.ecommerce.cart.model.Response;
import com.ecommerce.cart.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	ProductFeign feign;
	
	@Autowired
	CartRepository repository;
	
	@Override
	public Response saveToCart(String userId,String productName, Integer quantity) {
		// TODO Auto-generated method stub
		
		ResponseEntity<ProductResponse> singleProducts = feign.getSingleProducts(productName);
		ProductResponse body = singleProducts.getBody();
		List<ProductDTO> result = body.getResult();
		ProductDTO productDTO = result.get(0);
		CartEntity entity = new CartEntity();
		entity.setName(productName);
		entity.setCategory(productDTO.getCategory());
		entity.setPrice(productDTO.getPrice());
		entity.setQuantity(quantity);
		entity.setImages(productDTO.getImages());
		entity.setUserId(userId);
		entity.setSellerNumber(productDTO.getSellerNumber());
		entity.setTotalPrice(productDTO.getPrice() * quantity);
		
		CartEntity cart = repository.save(entity);
		
		Response response = new Response();
		response.setName(cart.getName());
		response.setCategory(cart.getCategory());
		response.setPrice(cart.getPrice());
		response.setQuantity(cart.getQuantity());
		response.setSellerNumber(cart.getSellerNumber());
		response.setTotalPrice(cart.getTotalPrice());
		List<ImageModel> imagelist = new ArrayList<>();
		for(ImageDTO dto: cart.getImages())
		{
			ImageModel image = new ImageModel();
			image.setImagedata(dto.getImagedata());
			image.setImageName(dto.getImageName());
			image.setImageType(dto.getImageType());
			imagelist.add(image);
		}
		response.setImages(imagelist);
		return response;
	}

	@Override
	public Response deleteCart(String userId, String productName) {
		
		CartEntity cart = repository.findByNameAndUserId(productName, userId).get(0);
		Response response = new Response();
		response.setName(cart.getName());
		response.setCategory(cart.getCategory());
		response.setPrice(cart.getPrice());
		response.setQuantity(cart.getQuantity());
		response.setSellerNumber(cart.getSellerNumber());
		response.setTotalPrice(cart.getTotalPrice());
		List<ImageModel> imagelist = new ArrayList<>();
		for(ImageDTO dto: cart.getImages())
		{
			ImageModel image = new ImageModel();
			image.setImagedata(dto.getImagedata());
			image.setImageName(dto.getImageName());
			image.setImageType(dto.getImageType());
			imagelist.add(image);
		}
		response.setImages(imagelist);
		
		String id = cart.getId();
		repository.deleteById(id);
		return response;
	}

	@Override
	public List<Response> viewAll(String userId) {
	 List<CartEntity> findByUserId = repository.findByUserId(userId);
		List<Response> responseList = new ArrayList<>();
		for(CartEntity cart : findByUserId )
		{
			Response response = new Response();
			response.setName(cart.getName());
			response.setCategory(cart.getCategory());
			response.setPrice(cart.getPrice());
			response.setQuantity(cart.getQuantity());
			response.setSellerNumber(cart.getSellerNumber());
			response.setTotalPrice(cart.getTotalPrice());
			List<ImageModel> imagelist = new ArrayList<>();
			for(ImageDTO dto: cart.getImages())
			{
				ImageModel image = new ImageModel();
				image.setImagedata(dto.getImagedata());
				image.setImageName(dto.getImageName());
				image.setImageType(dto.getImageType());
				imagelist.add(image);
			}
			response.setImages(imagelist);
			responseList.add(response);
		}
	   return responseList;
	}

	

	@Override
	public Response singleCart(String userId, String productName) {
		List<CartEntity> findByUserId = repository.findByNameAndUserId(productName, userId);
		CartEntity cart = findByUserId.get(0);
		Response response = new Response();
		response.setName(cart.getName());
		response.setCategory(cart.getCategory());
		response.setPrice(cart.getPrice());
		response.setQuantity(cart.getQuantity());
		response.setSellerNumber(cart.getSellerNumber());
		response.setTotalPrice(cart.getTotalPrice());
		List<ImageModel> imagelist = new ArrayList<>();
		for(ImageDTO dto: cart.getImages())
		{
			ImageModel image = new ImageModel();
			image.setImagedata(dto.getImagedata());
			image.setImageName(dto.getImageName());
			image.setImageType(dto.getImageType());
			imagelist.add(image);
		}
		response.setImages(imagelist);
	 return response;
		
	}

	@Override
	public List<Response> deleteAllCart(String userId) {
		List<CartEntity> findByUserId = repository.findByUserId(userId);
		List<Response> responseList = new ArrayList<>();
		for(CartEntity cart : findByUserId )
		{
			Response response = new Response();
			response.setName(cart.getName());
			response.setCategory(cart.getCategory());
			response.setPrice(cart.getPrice());
			response.setQuantity(cart.getQuantity());
			response.setSellerNumber(cart.getSellerNumber());
			response.setTotalPrice(cart.getTotalPrice());
			List<ImageModel> imagelist = new ArrayList<>();
			for(ImageDTO dto: cart.getImages())
			{
				ImageModel image = new ImageModel();
				image.setImagedata(dto.getImagedata());
				image.setImageName(dto.getImageName());
				image.setImageType(dto.getImageType());
				imagelist.add(image);
			}
			response.setImages(imagelist);
			responseList.add(response);
		}
		repository.deleteByUserId(userId);
		return responseList;
	}

}
