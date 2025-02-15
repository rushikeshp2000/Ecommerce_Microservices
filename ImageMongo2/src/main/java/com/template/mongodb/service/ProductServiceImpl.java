package com.template.mongodb.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.validation.Valid;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.base.Utf8;
import com.template.mongodb.enitty.ImageEntity;
import com.template.mongodb.enitty.ProductEntity;
import com.template.mongodb.mapping.Mapper;
import com.template.mongodb.model.ImageModel;
import com.template.mongodb.model.ImageModelDate;
import com.template.mongodb.model.Product;
import com.template.mongodb.model.ProductByte;
import com.template.mongodb.model.ProductPost;
import com.template.mongodb.repository.ProductRepository;

import io.swagger.annotations.ApiParam;

@Service
public class ProductServiceImpl implements ProductService {

	
	  @Autowired 
	  ProductRepository repository;
	  
	  @Autowired Mapper mapper;


	@Override
	public ProductByte imageByte(ProductByte byteModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductPost imageResource(ProductEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product imageString(String name, String category, List<ImageModel> image) {
		 ProductEntity entity = new ProductEntity();
		 entity.setName(name);
		 entity.setCategory(category);
		 List<ImageEntity> imagentity = mapper.mapToImageModel(image);
		 entity.setImage(imagentity);
		 ProductEntity save = repository.save(entity);
		 Product prodModel = mapper.mapToModel(entity);
		return prodModel;
	}

	@Override
	public Product saveProduct(String name, String category, List<MultipartFile> image) throws IOException {
		ProductEntity entity = new ProductEntity();
		entity.setName(name);
		entity.setCategory(category);
		List<ImageEntity> imagelist = new ArrayList<>();
		for(MultipartFile singleimage : image)
		{
			ImageEntity imageentity = new ImageEntity();
			imageentity.setImageName(singleimage.getOriginalFilename());
			imageentity.setImageType(singleimage.getContentType());
			imageentity.setImagedata(new Binary(BsonBinarySubType.BINARY,singleimage.getBytes()));
			imagelist.add(imageentity);
		}
		entity.setImage(imagelist);
		ProductEntity save = repository.save(entity);
		System.out.println(save);
		Product prodModel = new Product();
		prodModel.setName(save.getName());
		prodModel.setCategory(save.getCategory());
		List<ImageModelDate> imlist = new ArrayList<ImageModelDate>();
		for(ImageEntity it : save.getImage())
		{
			ImageModelDate imsingle = new ImageModelDate();
			imsingle.setImageName(it.getImageName());
			imsingle.setImageType(it.getImageType());
			byte[] binaryData = it.getImagedata().getData();
			 String encodedString = Base64.getEncoder().encodeToString(binaryData);
			imsingle.setImagedata(encodedString);
			imlist.add(imsingle);
		}
		prodModel.setImage(imlist);
		return prodModel;
		
		
	}

	@Override
	public Product SaveProduct(Product product) {
		ProductEntity entity = mapper.mapToEntity(product);
		List<ImageModelDate> prodListmodel = product.getImage();
		List<ImageEntity> imageListEntity = new ArrayList<>(); 
		for(ImageModelDate imageModelOne : prodListmodel)
		{
			ImageEntity imageentity = new ImageEntity();
		    imageentity.setImageName(imageModelOne.getImageName());
		    imageentity.setImageType(imageModelOne.getImageType());
		    byte[] data = Base64.getDecoder().decode(imageModelOne.getImagedata());
		    Binary binary = new Binary(data);
		    imageentity.setImagedata(binary);
		    imageListEntity.add(imageentity);
		}
		entity.setImage(imageListEntity);
		System.out.println(entity);
		ProductEntity save = repository.save(entity);
		System.out.println(save);
		Product prodModel = new Product();
		prodModel.setName(save.getName());
		prodModel.setCategory(save.getCategory());
		List<ImageModelDate> imlist = new ArrayList<ImageModelDate>();
		for(ImageEntity it : save.getImage())
		{
			ImageModelDate imsingle = new ImageModelDate();
			imsingle.setImageName(it.getImageName());
			imsingle.setImageType(it.getImageType());
			byte[] binaryData = it.getImagedata().getData();
			 String encodedString = Base64.getEncoder().encodeToString(binaryData);
			imsingle.setImagedata(encodedString);
			imlist.add(imsingle);
		}
		prodModel.setImage(imlist);
		return prodModel;
	}


	
		/*
		 * 
		 * @Override public Product saveProduct(String name, String category,
		 * List<MultipartFile> image) throws IOException { ProductEntity prodEntity =
		 * new ProductEntity(); prodEntity.setName(name);
		 * prodEntity.setCategory(category); List<Binary> listBinary = new
		 * ArrayList<>(); for(MultipartFile single : image) { listBinary.add(new
		 * Binary(BsonBinarySubType.BINARY,single.getBytes())); }
		 * prodEntity.setImage(listBinary); ProductEntity save =
		 * repository.save(prodEntity); System.out.println(save); Product prodModel =
		 * mapper.mapToModel(prodEntity); return prodModel; }
		 */
	
	
	/*
	 * @Autowired ProductRepository repo;
	 * 
	 * @Override public Product saveProduct(String name, String category,
	 * MultipartFile imagefile3) throws IOException { Product model = new Product();
	 * try { ProductEntity product = new ProductEntity(); product.setName(name);
	 * product.setCategory(category); product.setImagefile3(new
	 * Binary(BsonBinarySubType.BINARY,imagefile3.getBytes())); ProductEntity save =
	 * repo.save(product);
	 * 
	 * model.setName(save.getName()); model.setCategory(save.getCategory());
	 * Resource resource = new ByteArrayResource(save.getImagefile3().getData());
	 * model.setImagefile3(resource); }catch(Exception e) { e.printStackTrace(); }
	 * return model; }
	 * 
	 * @Override public List<Product> GetData() { List<Product> getProduct = new
	 * ArrayList<>(); List<ProductEntity> result = repo.findAll(); for(ProductEntity
	 * products : result ) { Product prodResult = new Product();
	 * prodResult.setName(products.getName());
	 * prodResult.setCategory(products.getCategory()); Resource resource = new
	 * ByteArrayResource(products.getImagefile3().getData());
	 * prodResult.setImagefile3(resource); System.out.println(prodResult);
	 * getProduct.add(prodResult); } // TODO Auto-generated method stub return
	 * getProduct; }
	 * 
	 * @Override public ProductEntity getSingleProduct(String name) { 
	 * ProductEntity
	 *              product = repo.findByName(name); return product; }
	 * 
	 * 
	 * @Override public ResponseEntity<ProductEntity> getTheproduct(String name) {
	 * ProductEntity entity = service.getSingleProduct(name); return new
	 * ResponseEntity<ProductEntity>(entity,HttpStatus.ACCEPTED); }
	 * 
	 * @RequestMapping(value = "/product/{name}", produces = { "application/json" },
	 * method = RequestMethod.GET) ResponseEntity<ProductEntity>
	 * getTheproduct(@ApiParam(value = "",required=true) @PathVariable("name")
	 * String name);
	 * 
	 * 
	 *   public ResponseEntity<Product> saveProduct(@ApiParam(value = "") @RequestPart(value="name", required=false)  String name,@ApiParam(value = "") @RequestPart(value="category", required=false)  String category,@ApiParam(value = "") @Valid @RequestPart(value = "image") List<MultipartFile> image) {

		for(MultipartFile file:image)
    	{
    		System.out.println(file.getResource());
    	}
    	Product saveProduct = null;
		try {
			saveProduct = service.saveProduct(name, category, image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return new ResponseEntity<Product>(saveProduct,HttpStatus.ACCEPTED);
    }
	 * 
	 */
}
