package com.template.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import com.template.mongodb.model.Product;
import com.template.mongodb.model.ProductByte;
import com.template.mongodb.service.ProductService;

import io.swagger.annotations.ApiParam;

import java.util.Optional;

import javax.validation.Valid;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-04T18:27:18.358939100+05:30[Asia/Calcutta]")

@Controller
@RequestMapping("${openapi.productMicroService.base-path:}")
public class ProductApiController implements ProductApi {

	@Autowired
	ProductService service;
	
    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ProductApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }
    
    public ResponseEntity<Product> saveProductMicro(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Product product) {
    	Product saveProduct = service.SaveProduct(product);
    	return new ResponseEntity<Product>(saveProduct,HttpStatus.ACCEPTED);
    }
    
    public ResponseEntity<ProductByte> saveProductByte(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ProductByte productByte) {
        return null;
    }
    

}
