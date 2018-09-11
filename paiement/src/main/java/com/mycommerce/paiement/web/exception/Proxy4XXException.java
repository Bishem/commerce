package com.mycommerce.paiement.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class Proxy4XXException extends RuntimeException {

	private static final long serialVersionUID = 4573480358710805563L;

	public Proxy4XXException(final String message) {

		super(message);
	}
}
