package com.ecommerce.product.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.product.entity.ImageEntity;
import com.ecommerce.product.entity.ProductEntity;
import com.ecommerce.product.exception.ProductNotFoundClass;
import com.ecommerce.product.mapper.MapStructMapper;
import com.ecommerce.product.model.ImageModel;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired 
	MapStructMapper mapper;
	 
	
	@Autowired
	ProductRepository repository;

	
	@Override
	public Product SaveProduct(String name, Double price, String details, Integer quantity, UUID sellerNumber,
			String category, Integer discount, List<MultipartFile> images) throws IOException {
		
		ProductEntity entitySave = new ProductEntity();
		entitySave.setName(name);
		entitySave.setPrice(price);
		entitySave.setDetails(details);
		entitySave.setQuantity(quantity);
		entitySave.setSellerNumber(sellerNumber);
		entitySave.setCategory(category);
		entitySave.setDiscount(discount);
		List<ImageEntity> imagelist = new ArrayList<>();
		for(MultipartFile file: images)
		{
			ImageEntity imageEntity = new ImageEntity();
			imageEntity.setImageName(file.getOriginalFilename());
			imageEntity.setImageType(file.getContentType());
			imageEntity.setImagedata(new Binary(BsonBinarySubType.BINARY,file.getBytes()));
			imagelist.add(imageEntity);
		}
		entitySave.setImage(imagelist);
		ProductEntity savedEntity = repository.save(entitySave);
		Product prodModel = mapper.entityToModel(savedEntity);
		List<ImageModel> listImageModel = new ArrayList<>();
		for(ImageEntity imageEntity : savedEntity.getImage())
		{
			ImageModel imageModel = new ImageModel();
			imageModel.setImageName(imageEntity.getImageName());
			imageModel.setImageType(imageEntity.getImageType());
			byte[] byteData = imageEntity.getImagedata().getData();
			String encodedString = Base64.getEncoder().encodeToString(byteData);
			imageModel.setImagedata(encodedString);
			listImageModel.add(imageModel);
		}
		prodModel.setImages(listImageModel);
		System.out.println(prodModel);
		return prodModel;
	}
	
	@Override
	public List<Product> GetAllProduct(Integer pageNumber, Integer pageSize) { 
		 Pageable pageable = PageRequest.of(pageNumber,pageSize);
		 Page<ProductEntity> findAllPageAble = repository.findAll(pageable);
		 List<ProductEntity> findAll = findAllPageAble.getContent();
		 List<Product> allProductList = mapper.listentityToModel(findAll);
		 for(ProductEntity prodEntity: findAll)
		 {
		    List<ImageModel> listImageModel = new ArrayList<>();
			for(ImageEntity imageEntity : prodEntity.getImage())
			{
				ImageModel imageModel = new ImageModel();
				imageModel.setImageName(imageEntity.getImageName());
				imageModel.setImageType(imageEntity.getImageType());
				byte[] byteData = imageEntity.getImagedata().getData();
				String encodedString = Base64.getEncoder().encodeToString(byteData);
				imageModel.setImagedata(encodedString);
				listImageModel.add(imageModel);
			}
			for(Product prodModel:allProductList )
			{
				prodModel.setImages(listImageModel);
			}
		 }
		return allProductList;
	}
	
	List<Product> AddBinaryFiles(List<ProductEntity> findAll)
	{
		 List<Product> allProductList = mapper.listentityToModel(findAll);
		 for(ProductEntity prodEntity: findAll)
		 {
		    List<ImageModel> listImageModel = new ArrayList<>();
			for(ImageEntity imageEntity : prodEntity.getImage())
			{
				ImageModel imageModel = new ImageModel();
				imageModel.setImageName(imageEntity.getImageName());
				imageModel.setImageType(imageEntity.getImageType());
				byte[] byteData = imageEntity.getImagedata().getData();
				String encodedString = Base64.getEncoder().encodeToString(byteData);
				imageModel.setImagedata(encodedString);
				listImageModel.add(imageModel);
			}
			for(Product prodModel:allProductList )
			{
				prodModel.setImages(listImageModel);
			}
		 }
		 return allProductList;
	}
	
	Product BinaryMaptoEntityClass(ProductEntity prodEntity)
	{
		Product prodModel = mapper.entityToModel(prodEntity);
		List<ImageModel> listImageModel = new ArrayList<>();
		for(ImageEntity imageEntity : prodEntity.getImage())
		{
			ImageModel imageModel = new ImageModel();
			imageModel.setImageName(imageEntity.getImageName());
			imageModel.setImageType(imageEntity.getImageType());
			byte[] byteData = imageEntity.getImagedata().getData();
			String encodedString = Base64.getEncoder().encodeToString(byteData);
			imageModel.setImagedata(encodedString);
			listImageModel.add(imageModel);
		}
		prodModel.setImages(listImageModel);
		System.out.println(prodModel);
		return prodModel;
	}

	@Override
	public Product viewSingleProduct(String productName) {
		ProductEntity findByName = repository.findByName(productName);
		if(findByName == null)
		{
			throw new ProductNotFoundClass("No such product of name " + productName + " available" );
		}
		Product findModel = BinaryMaptoEntityClass(findByName);
		return findModel;
	}

	@Override
	public Product viewSingleProductForSeller(String sellerID, String productName) {
		UUID uuid = UUID.fromString(sellerID);
		ProductEntity findBySellerNumberAndName = repository.findBySellerNumberAndName(uuid, productName);
		if(findBySellerNumberAndName == null)
		{
			throw new ProductNotFoundClass("No such product of name " + productName + " available" );
		}
		Product prodModel = BinaryMaptoEntityClass(findBySellerNumberAndName);
		return prodModel;

	}

	@Override public List<Product> viewAllProductsFromSeller(String category,String sellerID, Integer pageNumber, Integer pageSize) 
	{ 
		Pageable pageable = PageRequest.of(pageNumber,pageSize );
		UUID uuid = UUID.fromString(sellerID); 
		Page<ProductEntity> findBySellerNumberAndCategory2 = repository.findBySellerNumberAndCategory(uuid, category,pageable);
		List<ProductEntity> findBySellerNumberAndCategory = findBySellerNumberAndCategory2.getContent();
		List<Product> listProduct = AddBinaryFiles(findBySellerNumberAndCategory);
	    return listProduct; 
	}

	@Override
	public Void deleteProduct(String productName, String sellerID) {

		UUID uuid = UUID.fromString(sellerID);
		ProductEntity findBySellerNumberAndName = repository.findBySellerNumberAndName(uuid, productName);
		if(findBySellerNumberAndName == null)
		{
			throw new ProductNotFoundClass("No such product of name " + productName + " available" );
		}
		repository.deleteBySellerNumberAndName(uuid, productName);
		return null;
	}

	@Override 
	public List<Product> viewAllProductsOfCategory(String category, Integer pageNumber, Integer pageSize) 
	{
		Pageable pageable = PageRequest.of(pageNumber,pageSize);
		 Page<ProductEntity> findByCategory2 = repository.findByCategory(category,pageable);
		List<ProductEntity> findByCategory = findByCategory2.getContent();
		List<Product> listProduct = AddBinaryFiles(findByCategory);
		return listProduct; 
	
	}

	@Override
	public Product UpdateAProductOfSeller(String name,Double price,String details,Integer quantity,String sellerNumber,String category,Integer discount,List<MultipartFile> images) throws Exception
	{
		UUID uuid = UUID.fromString(sellerNumber);
		ProductEntity entitySave = new ProductEntity();
		entitySave.setName(name);
		entitySave.setPrice(price);
		entitySave.setDetails(details);
		entitySave.setQuantity(quantity);
		entitySave.setSellerNumber(uuid);
		entitySave.setCategory(category);
		entitySave.setDiscount(discount);
		List<ImageEntity> imagelist = new ArrayList<>();
		for(MultipartFile file: images)
		{
			ImageEntity imageEntity = new ImageEntity();
			imageEntity.setImageName(file.getOriginalFilename());
			imageEntity.setImageType(file.getContentType());
			imageEntity.setImagedata(new Binary(BsonBinarySubType.BINARY,file.getBytes()));
			imagelist.add(imageEntity);
		}
		entitySave.setImage(imagelist);
		ProductEntity findBySellerNumberAndName = repository.findBySellerNumberAndName(uuid, name);
		if(findBySellerNumberAndName == null)
		{
			throw new ProductNotFoundClass("No such product of name " + name + " available" );
		}

		ProductEntity updateproduct = repository.findBySellerNumberAndName(uuid, name);
		if(updateproduct != null)
		{
	    updateproduct.setId(updateproduct.getId());
		updateproduct.setName(entitySave.getName());
		updateproduct.setSellerNumber(entitySave.getSellerNumber());
		updateproduct.setCategory(entitySave.getCategory());
		updateproduct.setDetails(entitySave.getDetails());
		updateproduct.setDiscount(entitySave.getDiscount());
		updateproduct.setQuantity(entitySave.getQuantity());
		updateproduct.setPrice(entitySave.getPrice()); 
		updateproduct.setImage(entitySave.getImage());
		System.out.println(updateproduct);
		ProductEntity UpdatedEntity = repository.save(updateproduct);
		System.out.println(UpdatedEntity); 
		  Product UpdateModel = BinaryMaptoEntityClass(UpdatedEntity); 
		  return UpdateModel;	 
		}
		 
		return null;
	}

	@Override
	public List<Product> viewProductsDiscount(Integer discount,Integer pageNumber,Integer pageSize) {
		List<ProductEntity> findByDiscount = repository.findByDiscount(discount);
		System.out.println(findByDiscount);
		List<Product> prodDiscount = AddBinaryFiles(findByDiscount);
		System.out.println(prodDiscount);
		return prodDiscount;
	}

	@Override
	public List<Product> viewProductPrice(Double price, Integer pageNumber, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNumber,pageSize);
		Page<ProductEntity> byPrice = repository.findByPrice(price,pageable);
		List<ProductEntity> findByPrice = byPrice.getContent();
		List<Product> prodPrice = AddBinaryFiles(findByPrice);
		return prodPrice;
	}

	@Override
	public List<Product> viewProductCategoryDiscount(Integer discount, String category, Integer pageNumber, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNumber,pageSize);
		Page<ProductEntity> byCategoryAndDiscount = repository.findByCategoryAndDiscount(category, discount,pageable);
		List<ProductEntity> findByCategoryAndDiscount = byCategoryAndDiscount.getContent();
		List<Product> modellist = AddBinaryFiles(findByCategoryAndDiscount);
		return modellist;
	}

	@Override
	public List<Product> viewProductCategoryPrice(String category, Double price, Integer pageNumber, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNumber,pageSize);
		Page<ProductEntity> byCategoryAndPrice = repository.findByCategoryAndPrice(category, price,pageable);
		List<ProductEntity> findByCategoryAndPrice = byCategoryAndPrice.getContent();
		List<Product> prodList = AddBinaryFiles(findByCategoryAndPrice);
		
		return prodList;
	}


	
	

}
