package com.mycommerce.produit.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mycommerce.produit.configurations.ApplicationPropertiesConfiguration;
import com.mycommerce.produit.dao.ProduitDao;
import com.mycommerce.produit.model.Produit;
import com.mycommerce.produit.web.exception.ProduitIntrouvableException;

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

//		final List<Produit> listeLimitee = produits.subList(0, this.appProps.getLimiteDeProduits());

//		return listeLimitee;
		return produits;
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
