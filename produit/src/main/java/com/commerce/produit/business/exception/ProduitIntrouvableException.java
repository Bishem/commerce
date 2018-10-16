package com.commerce.produit.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProduitIntrouvableException extends RuntimeException {

    public ProduitIntrouvableException(final String message) {

        super(message);
    }
}
