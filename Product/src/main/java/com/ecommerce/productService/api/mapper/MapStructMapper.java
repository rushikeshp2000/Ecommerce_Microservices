package com.ecommerce.productService.api.mapper;

import org.mapstruct.Mapper;

import com.ecommerce.productService.api.entity.ProductEntity;
import com.ecommerce.productService.api.model.Product;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

	Product EntityToModel(ProductEntity product);
	ProductEntity ModelToEntity(Product productUser);
	
}
