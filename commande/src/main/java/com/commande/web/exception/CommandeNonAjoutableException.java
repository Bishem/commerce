package com.commande.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Si on en arrive à cette exception, c'est qu'il y a eu une erreur interne
 * Si la requête était mal formée, elle aurait déclenché 400 Bad Request automatiquement
 **/
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class CommandeNonAjoutableException extends RuntimeException {

	private static final long serialVersionUID = 3969626056824942480L;

	public CommandeNonAjoutableException(final String message) {

		super(message);
	}
}
