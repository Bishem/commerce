package com.mycommerce.paiement.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class PaiementExistantException extends RuntimeException {

	private static final long serialVersionUID = 5598689970826391925L;

	public PaiementExistantException(final String message) {

		super(message);
	}
}
