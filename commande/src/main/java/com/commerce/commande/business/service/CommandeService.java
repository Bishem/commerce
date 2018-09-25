package com.commerce.commande.business.service;

import java.util.Optional;

import com.commerce.commande.persistence.model.Commande;

public interface CommandeService {

	public Optional<Commande> getCommande(final Long id);

	public Commande postCommande(final Commande commande);

	public Commande putCommande(final Commande commande);
}
