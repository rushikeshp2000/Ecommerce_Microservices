package com.template.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import com.template.mongodb.model.Product;
import com.template.mongodb.service.ProductService;

import io.swagger.annotations.ApiParam;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-31T14:12:11.957898+05:30[Asia/Calcutta]")

@Controller
@RequestMapping("${openapi.productMicroService.base-path:}")
public class ProductsApiController implements ProductsApi {

	@Autowired
    ProductService ser;
	
	private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ProductsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }
    
    public ResponseEntity<List<Product>> getAllProducts() {
    	List<Product> product = ser.getProduct();
    	return new ResponseEntity<List<Product>>(product,HttpStatus.ACCEPTED);
    }

    
    public ResponseEntity<Product> saveProduct(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Product product) { 	
    	Product saveProduct = ser.saveProduct(product);
    	return new ResponseEntity<Product>(saveProduct,HttpStatus.ACCEPTED);
    }
}
