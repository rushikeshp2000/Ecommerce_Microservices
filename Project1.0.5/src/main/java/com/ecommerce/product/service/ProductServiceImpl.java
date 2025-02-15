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
import com.ecommerce.product.entity.PaginationCreater;
import com.ecommerce.product.entity.ProductEntity;
import com.ecommerce.product.entity.ProductStatus;
import com.ecommerce.product.exception.ProductNotFoundClass;
import com.ecommerce.product.exception.QuantityNotAvailable;
import com.ecommerce.product.mapper.MapStructMapper;
import com.ecommerce.product.model.ImageModel;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired 
	MapStructMapper mapper;
	 
	@Autowired
	PaginationCreater createPage;
	
	@Autowired
	ProductRepository repository;

	
	@Override
	public Product SaveProduct(String name, Double price, String details, Integer quantity, String sellerNumber,
			String category, Integer discount, List<MultipartFile> images) throws IOException {
		
		ProductEntity entitySave = new ProductEntity();
		entitySave.setName(name);
		entitySave.setPrice(price);
		entitySave.setDetails(details);
		entitySave.setQuantity(quantity);
		entitySave.setSellerNumber(sellerNumber);
		entitySave.setCategory(category);
		entitySave.setDiscount(discount);
		entitySave.setProdStatus(ProductStatus.ACTIVE);
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
		prodModel.setStatus(savedEntity.getProdStatus().toString());
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
		 Page<ProductEntity> findAllPageAble = repository.findByProdStatus(ProductStatus.ACTIVE, pageable);
		 createPage.setNumber(findAllPageAble.getNumber());
		 createPage.setNumberOfElements(findAllPageAble.getNumberOfElements());
		 createPage.setTotalElements(findAllPageAble.getTotalElements());
		 createPage.setTotalPages(findAllPageAble.getTotalPages());
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
		 List<Product> allProductList = new ArrayList<>();
		 for(ProductEntity prodEntity: findAll)
		 {
		    Product productModel = BinaryMaptoEntityClass(prodEntity);
		    allProductList.add(productModel);
		 }
		 return allProductList;
	}
	
	Product BinaryMaptoEntityClass(ProductEntity prodEntity)
	{
		Product prodModel = mapper.entityToModel(prodEntity);
		prodModel.setStatus(prodEntity.getProdStatus().toString());
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
		ProductEntity findBySellerNumberAndName = repository.findBySellerNumberAndName(sellerID, productName);
		if(findBySellerNumberAndName == null)
		{
			throw new ProductNotFoundClass("No such product of name " + productName + " available" );
		}
		findBySellerNumberAndName.setProdStatus(ProductStatus.ACTIVE);
		ProductEntity save = repository.save(findBySellerNumberAndName);
		Product prodModel = BinaryMaptoEntityClass(save);
		return prodModel;

	}

	@Override public List<Product> viewAllProductsFromSeller(String category,String sellerID, Integer pageNumber, Integer pageSize) 
	{ 
		Pageable pageable = PageRequest.of(pageNumber,pageSize );
		Page<ProductEntity> findBySellerNumberAndCategory2 = repository.findBySellerNumberAndCategory(sellerID, category,pageable);
		 createPage.setNumber(findBySellerNumberAndCategory2.getNumber());
		 createPage.setNumberOfElements(findBySellerNumberAndCategory2.getNumberOfElements());
		 createPage.setTotalElements(findBySellerNumberAndCategory2.getTotalElements());
		 createPage.setTotalPages(findBySellerNumberAndCategory2.getTotalPages());
		List<ProductEntity> findBySellerNumberAndCategory = findBySellerNumberAndCategory2.getContent();
		List<Product> listProduct = AddBinaryFiles(findBySellerNumberAndCategory);
	    return listProduct; 
	}

	@Override
	public Void deleteProduct(String productName, String sellerID) {
		ProductEntity findBySellerNumberAndName = repository.findBySellerNumberAndName(sellerID, productName);
		if(findBySellerNumberAndName == null)
		{
			throw new ProductNotFoundClass("No such product of name " + productName + " available" );
		}
		findBySellerNumberAndName.setProdStatus(ProductStatus.INACTIVE);
		repository.save(findBySellerNumberAndName);
		//repository.deleteBySellerNumberAndName(uuid, productName);
		return null;
	}

	@Override 
	public List<Product> viewAllProductsOfCategory(String category, Integer pageNumber, Integer pageSize) 
	{
		Pageable pageable = PageRequest.of(pageNumber,pageSize);
		 Page<ProductEntity> findByCategory2 = repository.findByCategoryAndProdStatus(category, ProductStatus.ACTIVE, pageable);
		 createPage.setNumber(findByCategory2.getNumber());
		 createPage.setNumberOfElements(findByCategory2.getNumberOfElements());
		 createPage.setTotalElements(findByCategory2.getTotalElements());
		 createPage.setTotalPages(findByCategory2.getTotalPages());
		List<ProductEntity> findByCategory = findByCategory2.getContent();
		List<Product> listProduct = AddBinaryFiles(findByCategory);
		return listProduct; 
	
	}

	@Override
	public Product UpdateAProductOfSeller(String name,Double price,String details,Integer quantity,String sellerNumber,String category,Integer discount,String status ,List<MultipartFile> images) throws Exception
	{
		System.out.println(status);
		ProductEntity entitySave = new ProductEntity();
		entitySave.setName(name);
		entitySave.setPrice(price);
		entitySave.setDetails(details);
		entitySave.setQuantity(quantity);
		entitySave.setSellerNumber(sellerNumber);
		entitySave.setCategory(category);
		entitySave.setDiscount(discount);
		if(status.equals("active"))
		{
			entitySave.setProdStatus(ProductStatus.ACTIVE);
			System.out.println("activated");
		}else
		{
			entitySave.setProdStatus(ProductStatus.INACTIVE);
			System.out.println("deactivated");
		}
		if(images !=  null)
		{
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
		}
		ProductEntity findBySellerNumberAndName = repository.findBySellerNumberAndName(sellerNumber, name);
		if(findBySellerNumberAndName == null)
		{
			throw new ProductNotFoundClass("No such product of name " + name + " available" );
		}

		ProductEntity updateproduct = repository.findBySellerNumberAndName(sellerNumber, name);
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
		if(images != null)
		{
			updateproduct.setImage(entitySave.getImage());
		}
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
	
	public ProductEntity getSingleProductCart(String name)
	{
		ProductEntity findByName = repository.findByName(name);
		return findByName;
	}

	@Override
	public List<Product> getBysellerId(String sellerNumber) {
		List<ProductEntity> findBySellerNumber = repository.findBySellerNumber(sellerNumber);
		List<Product> productList = AddBinaryFiles(findBySellerNumber);
		return productList;
	}

	@Override
	public List<Product> getBySellerIdAndStatus(String sellerID, String status) {
		if(status.equals("active"))
		{
				List<ProductEntity> findBySellerNumberAndProdStatus = repository.findBySellerNumberAndProdStatus(sellerID,ProductStatus.ACTIVE);
				List<Product> productList = AddBinaryFiles(findBySellerNumberAndProdStatus);
				return productList;
		}
		else {
			List<ProductEntity> findBySellerNumberAndProdStatus = repository.findBySellerNumberAndProdStatus(sellerID,ProductStatus.INACTIVE);
			List<Product> productList = AddBinaryFiles(findBySellerNumberAndProdStatus);
			return productList;
		}
	}

	@Override
	public List<Product> getBySellerIdAndStatusCategory(String sellerID, String status, String category) {
		 List<ProductEntity> findBySellerNumberAndCategory = repository.findBySellerNumberAndCategory(sellerID, category);
		 List<Product> productlist = new ArrayList<>();
		 for(ProductEntity entity : findBySellerNumberAndCategory)
		 {
			 if(status.equals("active"))
			 {
				 entity.setProdStatus(ProductStatus.ACTIVE);
			 }
			 else
			 {
				 entity.setProdStatus(ProductStatus.INACTIVE);
			 }
			 ProductEntity save = repository.save(entity);
			 Product product = BinaryMaptoEntityClass(save);
			 productlist.add(product);
		 }
		return productlist;
	}

	@Override
	public Product updateQuantity(String ProductName, Integer quantity) {
		ProductEntity findByName = repository.findByName(ProductName);
		Integer given = 0;
		ProductEntity save;
		if(quantity >= findByName.getQuantity())
		{
		    given = quantity - findByName.getQuantity();
			findByName.setQuantity(0);
			findByName.setProdStatus(ProductStatus.INACTIVE);
			 save = repository.save(findByName);       
		}else
		{
			given = findByName.getQuantity() - quantity;
			findByName.setQuantity(given);
			save = repository.save(findByName);
		}
		
		Product prodModel = BinaryMaptoEntityClass(save);
		
		return prodModel;
	}

}
