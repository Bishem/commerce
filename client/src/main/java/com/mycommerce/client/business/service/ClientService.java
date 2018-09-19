package com.mycommerce.client.business.service;

import java.util.List;

import com.mycommerce.client.business.binder.bean.CommandeBean;
import com.mycommerce.client.business.binder.bean.ProduitBean;

public interface ClientService {

	public List<ProduitBean> getAllProduits();

	public ProduitBean getProduitById(final Long id);

	public CommandeBean getNewCommande(final Long idProduit);

	public Boolean getNewPaiement(final Long idCommande);
}
