package com.ecommerce.product.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.product.entity.ImageEntity;
import com.ecommerce.product.entity.ProductEntity;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

	@InjectMocks
	ProductServiceImpl productService;
	
	@Mock
	ProductRepository repository;
	
	
	@Test
	void testSaveProduct() {
		ProductEntity entitySave = new ProductEntity();
		entitySave.setName("bottle");
		entitySave.setPrice(45.45);
		entitySave.setDetails("product is bottle ");
		entitySave.setQuantity(6);
		entitySave.setCategory("hardware");
		entitySave.setDiscount(20);
		
		when(repository.save(any(ProductEntity.class))).thenReturn(entitySave);
		
		ProductEntity product = repository.save(entitySave);
		
		assertNotNull(product);
		assertEquals(entitySave, product);
	}
	
	@Test
	void testViewSingleProduct()
	{
		ProductEntity entitySave = new ProductEntity();
		entitySave.setName("bottle");
		entitySave.setPrice(45.45);
		entitySave.setDetails("product is bottle ");
		entitySave.setQuantity(6);
		entitySave.setCategory("hardware");
		entitySave.setDiscount(20);
		
		
       System.out.println("single product");
	}

}
