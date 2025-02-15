package com.ecommerce.order.feign;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    private static final int CONNECT_TIMEOUT = 10000;
    private static final int READ_TIMEOUT = 10000;

    @SuppressWarnings("deprecation")
	@Bean
    public Request.Options requestOptions() {
        return new Request.Options(READ_TIMEOUT, CONNECT_TIMEOUT);
    }
}