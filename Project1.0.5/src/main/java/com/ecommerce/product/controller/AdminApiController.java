package com.ecommerce.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-14T19:35:05.706628+05:30[Asia/Calcutta]")

@Controller
@RequestMapping("${openapi.productMicroService.base-path:}")
public class AdminApiController implements AdminApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public AdminApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
