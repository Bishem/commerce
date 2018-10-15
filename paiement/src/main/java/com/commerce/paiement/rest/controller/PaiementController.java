package com.commerce.paiement.rest.controller;

import com.commerce.paiement.business.service.PaiementService;
import com.commerce.paiement.persistence.model.Paiement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PaiementController {

    private PaiementService paiementService;

    @Autowired
    public void setPaiementService(final PaiementService paiementService) {

        this.paiementService = paiementService;
    }

    @PostMapping(value = "/paiement")
    public ResponseEntity<Paiement> payerUneCommande(@Valid @RequestBody final Paiement paiement) {

        return new ResponseEntity<>(this.paiementService.postPaiement(paiement), HttpStatus.CREATED);
    }
}
