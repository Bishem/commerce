package com.paiement.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paiement.bean.CommandeBean;
import com.paiement.dao.PaiementDao;
import com.paiement.model.Paiement;
import com.paiement.proxy.CommandeProxy;
import com.paiement.web.exception.PaiementExistantException;
import com.paiement.web.exception.PaiementImpossibleException;

@RestController
public class PaiementController {

	@Autowired
	PaiementDao paiementDao;

	@Autowired
	CommandeProxy commandeProxy;

	/*
	 * Opération pour enregistrer un paiement et notifier le microservice commandes pour mettre à jour le statut de la commande en question
	 **/
	@PostMapping(value = "/paiement")
	public ResponseEntity<Paiement> payerUneCommande(@RequestBody final Paiement paiement) {

		// Vérifions s'il y a déjà un paiement enregistré pour cette commande
		final Paiement paiementExistant = this.paiementDao.findByidCommande(paiement.getIdCommande());

		if (paiementExistant != null) {
			throw new PaiementExistantException(new String("Cette commande est déjà payée"));
		}

		// Enregistrer le paiement
		final Paiement nouveauPaiement = this.paiementDao.save(paiement);

		// si le DAO nous retourne null c'est que il ya eu un problème lors de l'enregistrement
		if (nouveauPaiement == null) {
			throw new PaiementImpossibleException(
					new String("Erreur, impossible d'établir le paiement, réessayez plus tard"));
		}

		// On récupère la commande correspondant à ce paiement en faisant appel au Microservice commandes
		final Optional<CommandeBean> commandeReq = this.commandeProxy.recupererUneCommande(paiement.getIdCommande());

		// commandeReq.get() permet d'extraire l'objet de type CommandeBean de Optional
		final CommandeBean commande = commandeReq.get();

		// on met à jour l'objet pour marquer la commande comme étant payée
		commande.setCommandePayee(true);

		// on envoi l'objet commande mis à jour au microservice commande afin de mettre à jour le status de la commande.
		this.commandeProxy.updateCommande(commande);

		return new ResponseEntity<>(nouveauPaiement, HttpStatus.CREATED);
	}

}
