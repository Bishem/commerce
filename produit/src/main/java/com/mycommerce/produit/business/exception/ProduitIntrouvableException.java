package com.mycommerce.produit.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ProduitIntrouvableException extends RuntimeException {

	private static final long serialVersionUID = 9001647536625791031L;

	public ProduitIntrouvableException(final String message) {

		super(message);
	}
}
