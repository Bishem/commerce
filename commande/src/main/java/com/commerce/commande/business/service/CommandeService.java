package com.commerce.commande.business.service;

import com.commerce.commande.persistence.model.Commande;

public interface CommandeService {

    Commande readCommande(final Long id);

    Commande createCommande(final Commande commande);

    Commande updateCommande(final Commande commande);
}
