package com.mycommerce.produit.business.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mycommerce.produit.persistence.model.Produit;

@Service
public interface ProduitService {

	public List<Produit> getProduits();

	public Optional<Produit> getProduit(Long id);
}
