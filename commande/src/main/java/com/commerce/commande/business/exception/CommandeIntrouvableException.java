package com.commerce.commande.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CommandeIntrouvableException extends RuntimeException {

    public CommandeIntrouvableException(final String message) {

        super(message);
    }
}
