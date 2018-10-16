package com.commerce.produit.business.service;

import com.commerce.produit.persistence.model.Produit;

import java.util.List;

public interface ProduitService {

    List<Produit> readProduits();

    Produit readProduit(Long id);
}
