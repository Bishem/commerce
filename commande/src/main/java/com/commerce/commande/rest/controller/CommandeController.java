package com.commerce.commande.rest.controller;

import java.util.Optional;

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

	@Autowired
	private CommandeService commandeService;

	@GetMapping(value = "/commande/{id}")
	public Optional<Commande> recupererUneCommande(@PathVariable final Long id) {

		CommandeController.LOG.info("**** using {}", this.getClass().getSimpleName());

		return this.commandeService.getCommande(id);
	}

	@PostMapping(value = "/commande")
	public ResponseEntity<Commande> ajouterCommande(@RequestBody final Commande commande) {

		CommandeController.LOG.info("**** using {}", this.getClass().getSimpleName());

		return new ResponseEntity<>(this.commandeService.postCommande(commande), HttpStatus.CREATED);
	}

	/*
	 * Permet de mettre à jour une commande existante.
	 * save() mettra à jours uniquement les champs renseignés dans l'objet commande reçu. Ainsi dans ce cas, comme le champs date dans "commande"
	 * n'est
	 * pas renseigné, la date précédemment enregistrée restera en place
	 **/
	@PutMapping(value = "/commande")
	public ResponseEntity<Commande> updateCommande(@RequestBody final Commande commande) {

		CommandeController.LOG.info("**** using {}", this.getClass().getSimpleName());

		return new ResponseEntity<>(this.commandeService.putCommande(commande), HttpStatus.CREATED);
	}
}
