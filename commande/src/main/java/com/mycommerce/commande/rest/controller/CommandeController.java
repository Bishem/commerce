package com.mycommerce.commande.rest.controller;

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

import com.mycommerce.commande.business.exception.CommandeIntrouvableException;
import com.mycommerce.commande.business.exception.CommandeNonAjoutableException;
import com.mycommerce.commande.persistence.dao.CommandeDao;
import com.mycommerce.commande.persistence.model.Commande;

@RestController
public class CommandeController {

	private static final Logger LOG = LoggerFactory.getLogger(CommandeController.class);

	CommandeDao commandeDao;

	public CommandeController() {

	}

	@Autowired
	public void setCommandeDao(final CommandeDao commandeDao) {

		this.commandeDao = commandeDao;
	}

	@PostMapping(value = "/commande")
	public ResponseEntity<Commande> ajouterCommande(@RequestBody final Commande commande) {

		CommandeController.LOG.info("**** using {}", this.getClass().getSimpleName());

		final Commande nouvelleCommande = this.commandeDao.save(commande);

		if (nouvelleCommande == null) {
			throw new CommandeNonAjoutableException("Impossible d'ajouter cette commande");
		}

		return new ResponseEntity<>(commande, HttpStatus.CREATED);
	}

	@GetMapping(value = "/commande/{id}")
	public Optional<Commande> recupererUneCommande(@PathVariable final Long id) {

		CommandeController.LOG.info("**** using {}", this.getClass().getSimpleName());

		final Optional<Commande> commande = this.commandeDao.findById(id);

		if (!commande.isPresent()) {
			throw new CommandeIntrouvableException("Cette commande n'existe pas");
		}

		return commande;
	}

	/*
	 * Permet de mettre à jour une commande existante.
	 * save() mettra à jours uniquement les champs renseignés dans l'objet commande reçu. Ainsi dans ce cas, comme le champs date dans "commande"
	 * n'est
	 * pas renseigné, la date précédemment enregistrée restera en place
	 **/
	@PutMapping(value = "/commande")
	public void updateCommande(@RequestBody final Commande commande) {

		CommandeController.LOG.info("**** using {}", this.getClass().getSimpleName());

		this.commandeDao.save(commande);
	}
}
