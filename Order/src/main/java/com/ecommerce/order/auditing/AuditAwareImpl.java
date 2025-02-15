package com.ecommerce.order.auditing;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import jakarta.servlet.http.HttpServletRequest;

public class AuditAwareImpl implements AuditorAware<String>{

	private final HttpServletRequest request;
	
	@Autowired
	public AuditAwareImpl(HttpServletRequest request)
	{
		this.request = request;
	}
	
	@Override
	public Optional<String> getCurrentAuditor() {
		String userId = request.getParameter("userId");
		System.out.println(userId);
		return Optional.ofNullable(userId);
	}

}
