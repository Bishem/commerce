package com.mycommerce.commande.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycommerce.commande.business.exception.CommandeNonAjoutableException;
import com.mycommerce.commande.persistence.dao.CommandeDao;
import com.mycommerce.commande.persistence.model.Commande;

@Service
public class CommandeService {

	@Autowired
	CommandeDao commandeDao;

	public Commande postCommande(final Commande commande) {

		final Commande nouvelleCommande = this.commandeDao.save(commande);

		if (nouvelleCommande == null) {
			throw new CommandeNonAjoutableException("Impossible d'ajouter cette commande");
		}

		return nouvelleCommande;
	}
}
