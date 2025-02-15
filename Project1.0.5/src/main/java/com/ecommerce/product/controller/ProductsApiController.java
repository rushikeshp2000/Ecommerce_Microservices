package com.ecommerce.product.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.product.entity.PaginationCreater;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.model.ProductResponse;
import com.ecommerce.product.model.ProductResponsePageDate;
import com.ecommerce.product.service.ProductService;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-14T19:35:05.706628+05:30[Asia/Calcutta]")

@Controller
@RequestMapping("${openapi.productMicroService.base-path:}")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProductsApiController implements ProductsApi {

	@Autowired
	ProductService service;

	@Autowired
	PaginationCreater createPage;

	private final NativeWebRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public ProductsApiController(NativeWebRequest request) {
		this.request = request;
	}

	@Override
	public Optional<NativeWebRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	public ResponseEntity<ProductResponse> saveProduct(

			@ApiParam(value = "") @RequestPart(value = "name", required = false) String name,

			@ApiParam(value = "") @RequestPart(value = "price", required = false) String price,

			@ApiParam(value = "") @RequestPart(value = "details", required = false) String details,

			@ApiParam(value = "") @RequestPart(value = "quantity", required = false) String quantity,

			@ApiParam(value = "") @RequestPart(value = "sellerNumber", required = false) String sellerNumber,

			@ApiParam(value = "") @RequestPart(value = "category", required = false) String category,

			@ApiParam(value = "") @RequestPart(value = "discount", required = false) String discount,

			@ApiParam(value = "") @Valid @RequestPart(value = "images") List<MultipartFile> images) {
		Product saveProduct = null;
		try {
			saveProduct = service.SaveProduct(name, Double.parseDouble(price), details, Integer.parseInt(quantity),
					sellerNumber, category, Integer.parseInt(discount), images);
		} catch (NumberFormatException e) { //
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ProductResponse resultObject = new ProductResponse();
		resultObject.addResultItem(saveProduct);
		resultObject.setStatusCode(HttpStatus.CREATED.value());
		resultObject.setStatusMessage("Saved Product");
		return new ResponseEntity<ProductResponse>(resultObject, HttpStatus.OK);
	}

	public ResponseEntity<ProductResponse> getAllProducts(

			@ApiParam(value = "") @Valid @RequestParam(value = "name", required = false) String name,

			@ApiParam(value = "") @Valid @RequestParam(value = "price", required = false) Double price,

			@ApiParam(value = "") @Valid @RequestParam(value = "category", required = false) String category,

			@ApiParam(value = "") @Valid @RequestParam(value = "discount", required = false) Integer discount,

			@ApiParam(value = "", defaultValue = "0") @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,

			@ApiParam(value = "", defaultValue = "15") @Valid @RequestParam(value = "limit", required = false, defaultValue = "15") Integer limit) {
		List<Product> getAllProduct = service.GetAllProduct(offset, limit);
		ProductResponse resObject = new ProductResponse();
		resObject.setResult(getAllProduct);
		resObject.setStatusCode(HttpStatus.ACCEPTED.value());
		resObject.setStatusMessage("List of Products ");
		ProductResponsePageDate pageData = new ProductResponsePageDate();
		pageData.setLimit(createPage.getNumberOfElements());
		pageData.setOffset(createPage.getNumber());
		pageData.setTotalItems(createPage.getTotalElements());
		pageData.setTotalPages(createPage.getTotalPages());
		resObject.setPageDate(pageData);
		return new ResponseEntity<ProductResponse>(resObject, HttpStatus.OK);
	}

}
