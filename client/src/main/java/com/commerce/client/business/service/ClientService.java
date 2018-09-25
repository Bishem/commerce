package com.commerce.client.business.service;

import java.util.List;

import com.commerce.client.business.binder.bean.CommandeBean;
import com.commerce.client.business.binder.bean.ProduitBean;

public interface ClientService {

	public List<ProduitBean> getAllProduits();

	public ProduitBean getProduitById(final Long id);

	public CommandeBean getNewCommande(final Long idProduit);

	public Boolean getNewPaiement(final Long idCommande);
}
