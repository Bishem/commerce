package com.commerce.produit.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ProduitIntrouvableException extends RuntimeException {

    public ProduitIntrouvableException(final String message) {

        super(message);
    }
}
