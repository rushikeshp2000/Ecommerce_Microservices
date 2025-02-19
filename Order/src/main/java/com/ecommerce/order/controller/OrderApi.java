/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.ecommerce.order.controller;

import com.ecommerce.order.model.Order;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-15T02:17:57.182843300+05:30[Asia/Calcutta]")

@Validated
@Api(value = "order", description = "the order API")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public interface OrderApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /order/{UserId} : Create new entry for order of all products
     * This is used to create the order entry.
     *
     * @param userId  (required)
     * @return Succesfull operation. (status code 200)
     */
    @ApiOperation(value = "Create new entry for order of all products", nickname = "createALLCartOrder", notes = "This is used to create the order entry.", response = Order.class, tags={ "Order", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succesfull operation.", response = Order.class) })
    @RequestMapping(value = "/order/{UserId}",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    default ResponseEntity<Order> createALLCartOrder(@ApiParam(value = "",required=true) @PathVariable("UserId") String userId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"results\" : [ { \"updateDate\" : \"updateDate\", \"UserName\" : \"UserName\", \"quantity\" : 6, \"ProductName\" : \"ProductName\", \"orderId\" : \"orderId\", \"UserAddress\" : \"UserAddress\", \"UserEmail\" : \"UserEmail\", \"Totalprice\" : 1.4658129805029452, \"createdDate\" : \"createdDate\", \"UserPhone\" : \"UserPhone\", \"createdBy\" : \"createdBy\", \"UserId\" : \"UserId\", \"price\" : 0.8008281904610115, \"SellerId\" : \"SellerId\" }, { \"updateDate\" : \"updateDate\", \"UserName\" : \"UserName\", \"quantity\" : 6, \"ProductName\" : \"ProductName\", \"orderId\" : \"orderId\", \"UserAddress\" : \"UserAddress\", \"UserEmail\" : \"UserEmail\", \"Totalprice\" : 1.4658129805029452, \"createdDate\" : \"createdDate\", \"UserPhone\" : \"UserPhone\", \"createdBy\" : \"createdBy\", \"UserId\" : \"UserId\", \"price\" : 0.8008281904610115, \"SellerId\" : \"SellerId\" } ], \"statusMessage\" : \"Operation completed successful\", \"statusCode\" : 200 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /order/{UserId}/{ProductName} : Create new entry for order
     * This is used to create the order entry.
     *
     * @param userId  (required)
     * @param productName  (required)
     * @return Succesfull operation. (status code 200)
     */
    @ApiOperation(value = "Create new entry for order", nickname = "createOrder", notes = "This is used to create the order entry.", response = Order.class, tags={ "Order", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succesfull operation.", response = Order.class) })
    @RequestMapping(value = "/order/{UserId}/{ProductName}",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    default ResponseEntity<Order> createOrder(@ApiParam(value = "",required=true) @PathVariable("UserId") String userId,@ApiParam(value = "",required=true) @PathVariable("ProductName") String productName) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"results\" : [ { \"updateDate\" : \"updateDate\", \"UserName\" : \"UserName\", \"quantity\" : 6, \"ProductName\" : \"ProductName\", \"orderId\" : \"orderId\", \"UserAddress\" : \"UserAddress\", \"UserEmail\" : \"UserEmail\", \"Totalprice\" : 1.4658129805029452, \"createdDate\" : \"createdDate\", \"UserPhone\" : \"UserPhone\", \"createdBy\" : \"createdBy\", \"UserId\" : \"UserId\", \"price\" : 0.8008281904610115, \"SellerId\" : \"SellerId\" }, { \"updateDate\" : \"updateDate\", \"UserName\" : \"UserName\", \"quantity\" : 6, \"ProductName\" : \"ProductName\", \"orderId\" : \"orderId\", \"UserAddress\" : \"UserAddress\", \"UserEmail\" : \"UserEmail\", \"Totalprice\" : 1.4658129805029452, \"createdDate\" : \"createdDate\", \"UserPhone\" : \"UserPhone\", \"createdBy\" : \"createdBy\", \"UserId\" : \"UserId\", \"price\" : 0.8008281904610115, \"SellerId\" : \"SellerId\" } ], \"statusMessage\" : \"Operation completed successful\", \"statusCode\" : 200 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /order : get all entry
     * This is used to get all the entries.
     *
     * @return Succesfull operation. (status code 200)
     */
    @ApiOperation(value = "get all entry", nickname = "getOrder", notes = "This is used to get all the entries.", response = Order.class, tags={ "Order", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succesfull operation.", response = Order.class) })
    @RequestMapping(value = "/order",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Order> getOrder() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"results\" : [ { \"updateDate\" : \"updateDate\", \"UserName\" : \"UserName\", \"quantity\" : 6, \"ProductName\" : \"ProductName\", \"orderId\" : \"orderId\", \"UserAddress\" : \"UserAddress\", \"UserEmail\" : \"UserEmail\", \"Totalprice\" : 1.4658129805029452, \"createdDate\" : \"createdDate\", \"UserPhone\" : \"UserPhone\", \"createdBy\" : \"createdBy\", \"UserId\" : \"UserId\", \"price\" : 0.8008281904610115, \"SellerId\" : \"SellerId\" }, { \"updateDate\" : \"updateDate\", \"UserName\" : \"UserName\", \"quantity\" : 6, \"ProductName\" : \"ProductName\", \"orderId\" : \"orderId\", \"UserAddress\" : \"UserAddress\", \"UserEmail\" : \"UserEmail\", \"Totalprice\" : 1.4658129805029452, \"createdDate\" : \"createdDate\", \"UserPhone\" : \"UserPhone\", \"createdBy\" : \"createdBy\", \"UserId\" : \"UserId\", \"price\" : 0.8008281904610115, \"SellerId\" : \"SellerId\" } ], \"statusMessage\" : \"Operation completed successful\", \"statusCode\" : 200 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
