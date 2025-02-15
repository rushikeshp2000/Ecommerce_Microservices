package com.ecommerce.product.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.ecommerce.product.entity.ProductEntity;
import com.ecommerce.product.model.Product;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

	Product entityToModel(ProductEntity prodEntity);
	ProductEntity modelToEntity(Product prodModel);
	
	List<Product> listentityToModel(List<ProductEntity> listProdEntity);
	List<ProductEntity> listmodelToEntity(List<Product> prodModel);
}
