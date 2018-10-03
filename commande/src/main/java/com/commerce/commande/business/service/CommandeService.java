package com.commerce.commande.business.service;

import com.commerce.commande.persistence.model.Commande;

public interface CommandeService {

	Commande getCommande(final Long id);

	Commande postCommande(final Commande commande);

	Commande putCommande(final Commande commande);
}
