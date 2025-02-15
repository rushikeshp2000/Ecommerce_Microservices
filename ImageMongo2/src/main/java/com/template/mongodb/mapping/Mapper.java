package com.template.mongodb.mapping;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.template.mongodb.enitty.ImageEntity;
import com.template.mongodb.enitty.ProductEntity;
import com.template.mongodb.model.ImageModel;
import com.template.mongodb.model.Product;
import com.template.mongodb.model.ProductByte;
import com.template.mongodb.model.ProductPost;

@Component
public class Mapper {
	
	@Autowired
	ModelMapper mapper;
	
	public ProductEntity mapToEntity(Product prodModel)
	{
		ProductEntity product = mapper.map(prodModel, ProductEntity.class);
		return product;
	}
	
	public Product mapToModel(ProductEntity prodEntity)
	{
		Product prodModel = mapper.map(prodEntity, Product.class);
		return prodModel;
	}
	
	public ProductEntity mapToByteEntity(ProductByte prodModel)
	{
		ProductEntity product = mapper.map(prodModel, ProductEntity.class);
		return product;
	}
	
	public ProductByte mapToByteModel(ProductEntity prodEntity)
	{
		ProductByte prodModel = mapper.map(prodEntity, ProductByte.class);
		return prodModel;
	}
	
	public ProductEntity mapToResourceEntity(ProductPost prodModel)
	{
		ProductEntity product = mapper.map(prodModel, ProductEntity.class);
		return product;
	}
	
	public ProductPost mapToResourceModel(ProductEntity prodEntity)
	{
		ProductPost prodModel = mapper.map(prodEntity, ProductPost.class);
		return prodModel;
	}
	
	public ImageModel mapToImageEntity(ImageEntity entity)
	{
		ImageModel model = mapper.map(entity, ImageModel.class);
		return model;
	}
	
	public ImageEntity mapToImageModel(ImageModel entity)
	{
		ImageEntity model = mapper.map(entity, ImageEntity.class);
		return model;
	}
	
	public List<ImageModel> mapToImageEntity(List<ImageEntity> listentity)
	{
		List<ImageModel> modellist = new ArrayList<>();
		for(ImageEntity entity: listentity)
		{
			ImageModel model = mapper.map(entity, ImageModel.class);
			modellist.add(model);
		}
		
		return modellist;
	}
	
	public List<ImageEntity> mapToImageModel(List<ImageModel> listmodel)
	{
		List<ImageEntity> entitylist = new ArrayList<>();
		for(ImageModel model: listmodel)
		{
			ImageEntity entity = mapper.map(model, ImageEntity.class);
			entitylist.add(entity);
		}
		
		return entitylist;
	}
	
}
