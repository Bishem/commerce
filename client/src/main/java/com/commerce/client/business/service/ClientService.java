package com.commerce.client.business.service;

import com.commerce.client.business.binder.bean.CommandeBean;
import com.commerce.client.business.binder.bean.ExpeditionBean;
import com.commerce.client.business.binder.bean.PaiementBean;
import com.commerce.client.business.binder.bean.ProduitBean;

import java.util.List;

public interface ClientService {

    List<ProduitBean> listerProduits();

    ProduitBean recupererProduit(final Long id);

    CommandeBean creerCommande(final Long idProduit);

    PaiementBean creerPaiement(final Long idCommande);

    ExpeditionBean recupererExpedition(Long idPaiement);
}
