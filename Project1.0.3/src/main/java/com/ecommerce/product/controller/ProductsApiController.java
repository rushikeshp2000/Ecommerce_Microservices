package com.ecommerce.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.model.ProductResponse;
import com.ecommerce.product.service.ProductService;

import io.swagger.annotations.ApiParam;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-01T13:20:49.502642+05:30[Asia/Calcutta]")

@Controller
@RequestMapping("${openapi.productMicroService.base-path:}")
public class ProductsApiController implements ProductsApi {

    private final NativeWebRequest request;

    @Autowired
	ProductService service;
    
    @org.springframework.beans.factory.annotation.Autowired
    public ProductsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }
    
    public ResponseEntity<ProductResponse> saveProduct(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Product product) {
    	Product saveProduct = service.SaveProduct(product);
    	ProductResponse resultObject = new ProductResponse();
    	resultObject.addResultItem(saveProduct);
    	resultObject.setStatusCode(HttpStatus.CREATED.value());
    	resultObject.setStatusMessage("Saved Product");
		return new ResponseEntity<ProductResponse>(resultObject,HttpStatus.OK);
    
    }

    public ResponseEntity<ProductResponse> getAllProducts(@ApiParam(value = "") @Valid @RequestParam(value = "name", required = false) String name,@ApiParam(value = "", defaultValue = "0") @Valid @RequestParam(value = "pageNumber", required = false, defaultValue="0") Integer pageNumber,@ApiParam(value = "", defaultValue = "15") @Valid @RequestParam(value = "pageSize", required = false, defaultValue="15") Integer pageSize) {
		List<Product> getAllProduct = service.GetAllProduct();
		ProductResponse resObject = new ProductResponse();
		resObject.setResult(getAllProduct);
		resObject.setStatusCode(HttpStatus.ACCEPTED.value());
		resObject.setStatusMessage("List of Products ");
		return new ResponseEntity<ProductResponse>(resObject, HttpStatus.OK);
    }

}
