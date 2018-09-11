package com.commande.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CommandeIntrouvableException extends RuntimeException {

	private static final long serialVersionUID = -2155776587242344388L;

	public CommandeIntrouvableException(final String message) {

		super(message);
	}
}
