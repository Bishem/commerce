package com.commerce.paiement.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.paiement.business.service.PaiementService;
import com.commerce.paiement.persistence.model.Paiement;

@RefreshScope
@RestController
public class PaiementController {

	private static final Logger LOG = LoggerFactory.getLogger(PaiementController.class);

	private PaiementService paiementService;

	public PaiementController() {

	}

	@Autowired
	public PaiementController(final PaiementService paiementService) {

		this.paiementService = paiementService;
	}

	/*
	 * Opération pour enregistrer un paiement et notifier le microservice commandes pour mettre à jour le statut de la commande en question
	 **/
	@PostMapping(value = "/paiement")
	public ResponseEntity<Paiement> payerUneCommande(@RequestBody final Paiement paiement) {

		PaiementController.LOG.info("**** using {} : {}", this.getClass().getSimpleName(), this.hashCode());

		final ResponseEntity<Paiement> paiementAjoutee = new ResponseEntity<>(this.paiementService.postPaiement(paiement), HttpStatus.CREATED);

		PaiementController.LOG.info("**** done with {} : {}", this.getClass().getSimpleName(), this.hashCode());

		return paiementAjoutee;
	}
}
