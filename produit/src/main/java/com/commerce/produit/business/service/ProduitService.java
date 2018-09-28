package com.commerce.produit.business.service;

import java.util.List;
import java.util.Optional;

import com.commerce.produit.persistence.model.Produit;

public interface ProduitService {

	public List<Produit> getProduits();

	public Optional<Produit> getProduit(Long id);
}
