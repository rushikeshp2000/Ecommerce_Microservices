package com.template.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;

import com.template.mongodb.model.ImageModel;
import com.template.mongodb.model.Product;
import com.template.mongodb.service.ProductService;

import io.swagger.annotations.ApiParam;

import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-04T17:02:42.150979100+05:30[Asia/Calcutta]")

@Controller
@RequestMapping("${openapi.productMicroService.base-path:}")
public class ProductsApiController implements ProductsApi {

	@Autowired
	ProductService service;
	
    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ProductsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }
    
    public ResponseEntity<Product> saveProduct(@ApiParam(value = "") @RequestPart(value="name", required=false)  String name,
    		@ApiParam(value = "") @RequestPart(value="category", required=false)  String category,
    		@ApiParam(value = "") @RequestPart(value="image", required=false)  List<ImageModel> image) 
    {
    	Product imageString = service.imageString(name, category, image);	
    	return new ResponseEntity<Product>(imageString,HttpStatus.ACCEPTED);
    }

}
