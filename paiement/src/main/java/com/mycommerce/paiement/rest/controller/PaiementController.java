package com.mycommerce.paiement.rest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycommerce.paiement.business.binder.bean.CommandeBean;
import com.mycommerce.paiement.business.binder.proxy.CommandeProxy;
import com.mycommerce.paiement.business.exception.PaiementExistantException;
import com.mycommerce.paiement.business.exception.PaiementImpossibleException;
import com.mycommerce.paiement.persistence.dao.PaiementDao;
import com.mycommerce.paiement.persistence.model.Paiement;

@RestController
public class PaiementController {

	@Autowired
	private PaiementDao paiementDao;

	@Autowired
	private CommandeProxy commandeProxy;

	/*
	 * Opération pour enregistrer un paiement et notifier le microservice commandes pour mettre à jour le statut de la commande en question
	 **/
	@PostMapping(value = "/paiement")
	public ResponseEntity<Paiement> payerUneCommande(@RequestBody final Paiement paiement) {

		final Paiement paiementRecupere = this.paiementDao.findByidCommande(paiement.getIdCommande());

		if (paiementRecupere.equals(null)) {
			throw new PaiementExistantException("Cette commande est déjà payée");
		}

		final Paiement paiementAjoutee = this.paiementDao.save(paiement);

		if (paiementAjoutee.equals(null)) {
			throw new PaiementImpossibleException("Erreur, impossible d'établir le paiement, réessayez plus tard");
		}

		final Optional<CommandeBean> commandeRecuperee = this.commandeProxy
				.recupererUneCommande(paiement.getIdCommande());

		commandeRecuperee.get().setEstPayee(true);

		this.commandeProxy.updateCommande(commandeRecuperee.get());

		return new ResponseEntity<>(paiementAjoutee, HttpStatus.CREATED);
	}
}
