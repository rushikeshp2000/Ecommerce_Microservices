package com.ecommerce.product.Auditing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableMongoAuditing
public class AuditConfig {

	
	@Bean 
	public AuditorAware<String> myAuditprovider(HttpServletRequest request)
	{
		return new AuditAwareImpl(request);
	}
}
