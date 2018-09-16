package com.mycommerce.paiement.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class PaiementImpossibleException extends RuntimeException {

	private static final long serialVersionUID = -3344460685464583082L;

	public PaiementImpossibleException(final String message) {

		super(message);
	}
}
