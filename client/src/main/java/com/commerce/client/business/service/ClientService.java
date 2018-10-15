package com.commerce.client.business.service;

import com.commerce.client.business.binder.bean.CommandeBean;
import com.commerce.client.business.binder.bean.ExpeditionBean;
import com.commerce.client.business.binder.bean.PaiementBean;
import com.commerce.client.business.binder.bean.ProduitBean;

import java.util.List;

public interface ClientService {

    List<ProduitBean> getAllProduits();

    ProduitBean getProduitById(final Long id);

    CommandeBean getNewCommande(final Long idProduit);

    PaiementBean getNewPaiement(final Long idCommande);

    ExpeditionBean getNewExpedition(Long idPaiement);
}
