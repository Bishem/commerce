package com.commerce.commande.business.service;

import java.util.Optional;

import com.commerce.commande.persistence.model.Commande;

public interface CommandeService {

	Optional<Commande> getCommande(final Long id);

	Commande postCommande(final Commande commande);

	Commande putCommande(final Commande commande);
}
