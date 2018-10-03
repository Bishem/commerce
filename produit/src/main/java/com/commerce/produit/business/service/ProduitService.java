package com.commerce.produit.business.service;

import java.util.List;

import com.commerce.produit.persistence.model.Produit;

public interface ProduitService {

	List<Produit> getProduits();

	Produit getProduit(Long id);
}
