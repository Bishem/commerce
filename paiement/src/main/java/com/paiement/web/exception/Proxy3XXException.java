package com.paiement.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.MULTIPLE_CHOICES)
public class Proxy3XXException extends RuntimeException {

	private static final long serialVersionUID = 961495203559218700L;

	public Proxy3XXException(final String message) {

		super(message);
	}

}
