package com.commerce.paiement.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class PaiementExistantException extends RuntimeException {

    public PaiementExistantException(final String message) {

        super(message);
    }
}
