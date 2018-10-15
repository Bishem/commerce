package com.commerce.expedition.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ExpeditionExistanteException extends RuntimeException {

    public ExpeditionExistanteException(final String message) {

        super(message);
    }
}
