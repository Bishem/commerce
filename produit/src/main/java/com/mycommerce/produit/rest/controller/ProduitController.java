package com.mycommerce.produit.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mycommerce.produit.business.configuration.ApplicationPropertiesConfiguration;
import com.mycommerce.produit.business.exception.ProduitIntrouvableException;
import com.mycommerce.produit.persistence.dao.ProduitDao;
import com.mycommerce.produit.persistence.model.Produit;

@RestController
public class ProduitController {

	@Autowired
	ProduitDao produitDao;

	@Autowired
	ApplicationPropertiesConfiguration appProps;

	// Affiche la liste de tous les produits disponibles
	@GetMapping(value = "/produit")
	public List<Produit> listeDesProduits() {

		final List<Produit> produits = this.produitDao.findAll();

		if (produits.isEmpty()) {
			throw new ProduitIntrouvableException(new String("Aucun produit n'est disponible à la vente"));
		}

		final List<Produit> produitsLimites = produits.subList(0, this.appProps.getLimiteDeProduits());

		return produitsLimites;
	}

	// Récuperer un produit par son id
	@GetMapping(value = "/produit/{id}")
	public Optional<Produit> recupererUnProduit(@PathVariable final Long id) {

		final Optional<Produit> produit = this.produitDao.findById(id);

		if (!produit.isPresent()) {
			throw new ProduitIntrouvableException(
					new String("Le produit correspondant à l'id " + id + " n'existe pas"));
		}

		return produit;
	}
}
