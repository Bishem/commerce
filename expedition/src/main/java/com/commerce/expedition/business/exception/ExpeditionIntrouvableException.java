package com.commerce.expedition.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExpeditionIntrouvableException extends RuntimeException {

    public ExpeditionIntrouvableException(final String message) {

        super(message);
    }
}
