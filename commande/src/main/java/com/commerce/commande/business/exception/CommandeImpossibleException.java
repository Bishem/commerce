package com.commerce.commande.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class CommandeImpossibleException extends RuntimeException {

    public CommandeImpossibleException(final String message) {

        super(message);
    }
}
