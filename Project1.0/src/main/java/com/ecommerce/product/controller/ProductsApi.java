/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.ecommerce.product.controller;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.model.ProductResponse;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-01T10:11:09.516412300+05:30[Asia/Calcutta]")

@Validated
@Api(value = "products", description = "the products API")
public interface ProductsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /products : get all the products
     * It gets all the products from the database
     *
     * @param name  (optional)
     * @param pageNumber  (optional, default to 0)
     * @param pageSize  (optional, default to 15)
     * @return okay accepted (status code 200)
     */
    @ApiOperation(value = "get all the products", nickname = "getAllProducts", notes = "It gets all the products from the database", response = ProductResponse.class, tags={ "UserProduct", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "okay accepted", response = ProductResponse.class) })
    @RequestMapping(value = "/products",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<ProductResponse> getAllProducts(@ApiParam(value = "") @Valid @RequestParam(value = "name", required = false) String name,@ApiParam(value = "", defaultValue = "0") @Valid @RequestParam(value = "pageNumber", required = false, defaultValue="0") Integer pageNumber,@ApiParam(value = "", defaultValue = "15") @Valid @RequestParam(value = "pageSize", required = false, defaultValue="15") Integer pageSize) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"result\" : [ { \"quantity\" : 10, \"sellerNumber\" : \"ae04a3db-8169-4f91-95f9-478bdb107840\", \"price\" : 12.25, \"name\" : \"shoes\", \"discount\" : 20, \"details\" : \"description of the image that we want to show\", \"category\" : \"hardware\" }, { \"quantity\" : 10, \"sellerNumber\" : \"ae04a3db-8169-4f91-95f9-478bdb107840\", \"price\" : 12.25, \"name\" : \"shoes\", \"discount\" : 20, \"details\" : \"description of the image that we want to show\", \"category\" : \"hardware\" } ], \"statusMessage\" : \"Operation completed successful\", \"statusCode\" : 200 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /products : post a product to database
     * it is used to save the data
     *
     * @param product  (required)
     * @return okay accepted (status code 201)
     */
    @ApiOperation(value = "post a product to database", nickname = "saveProduct", notes = "it is used to save the data", response = Product.class, tags={ "SellerProduct", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "okay accepted", response = Product.class) })
    @RequestMapping(value = "/products",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Product> saveProduct(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Product product) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"quantity\" : 10, \"sellerNumber\" : \"ae04a3db-8169-4f91-95f9-478bdb107840\", \"price\" : 12.25, \"name\" : \"shoes\", \"discount\" : 20, \"details\" : \"description of the image that we want to show\", \"category\" : \"hardware\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
