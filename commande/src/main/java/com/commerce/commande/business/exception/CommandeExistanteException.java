package com.commerce.commande.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CommandeExistanteException extends RuntimeException {

    public CommandeExistanteException(final String message) {

        super(message);
    }
}
