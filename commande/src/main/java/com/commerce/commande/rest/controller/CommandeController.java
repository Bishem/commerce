package com.commerce.commande.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.commande.business.service.CommandeService;
import com.commerce.commande.persistence.model.Commande;

@RestController
public class CommandeController {

	private static final Logger LOG = LoggerFactory.getLogger(CommandeController.class);

	private CommandeService commandeService;

	@Autowired
	public void setCommandeService(final CommandeService commandeService) {

		this.commandeService = commandeService;
	}

	@GetMapping(value = "/commande/{id}")
	public Commande recupererUneCommande(@PathVariable final Long id) {

		CommandeController.LOG.info("**** using {} : {}", this.getClass().getSimpleName(), this.hashCode());

		final Commande commandeRecuperee = this.commandeService.getCommande(id);

		CommandeController.LOG.info("**** done with {} : {}", this.getClass().getSimpleName(), this.hashCode());

		return commandeRecuperee;
	}

	@PostMapping(value = "/commande")
	public ResponseEntity<Commande> ajouterCommande(@RequestBody final Commande commande) {

		CommandeController.LOG.info("**** using {} : {}", this.getClass().getSimpleName(), this.hashCode());

		final ResponseEntity<Commande> commandeAjoutee = new ResponseEntity<>(this.commandeService.postCommande(commande), HttpStatus.CREATED);

		CommandeController.LOG.info("**** done with {} : {}", this.getClass().getSimpleName(), this.hashCode());

		return commandeAjoutee;
	}

	/*
	 * Permet de mettre à jour une commande existante.
	 * save() mettra à jours uniquement les champs renseignés dans l'objet commande reçu. Ainsi dans ce cas, comme le champs date dans "commande"
	 * n'est
	 * pas renseigné, la date précédemment enregistrée restera en place
	 **/
	@PutMapping(value = "/commande")
	public ResponseEntity<Commande> updateCommande(@RequestBody final Commande commande) {

		CommandeController.LOG.info("**** using {} : {}", this.getClass().getSimpleName(), this.hashCode());

		final ResponseEntity<Commande> commandeUpdated = new ResponseEntity<>(this.commandeService.putCommande(commande), HttpStatus.CREATED);

		CommandeController.LOG.info("**** done with {} : {}", this.getClass().getSimpleName(), this.hashCode());

		return commandeUpdated;
	}
}
