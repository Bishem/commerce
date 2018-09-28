package com.commerce.client.business.service;

import java.util.List;

import com.commerce.client.business.binder.bean.CommandeBean;
import com.commerce.client.business.binder.bean.ProduitBean;

public interface ClientService {

	List<ProduitBean> getAllProduits();

	ProduitBean getProduitById(final Long id);

	CommandeBean getNewCommande(final Long idProduit);

	Boolean getNewPaiement(final Long idCommande);

}
