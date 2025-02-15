package com.ecommerce.product.exception;

public class QuantityNotAvailable extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuantityNotAvailable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuantityNotAvailable(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public QuantityNotAvailable(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public QuantityNotAvailable(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public QuantityNotAvailable(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
