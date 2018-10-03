package com.commerce.produit.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.produit.business.service.ProduitService;
import com.commerce.produit.persistence.model.Produit;

@RestController
public class ProduitController {

	private static final Logger LOG = LoggerFactory.getLogger(ProduitController.class);

	ProduitService produitService;

	@Autowired
	public void setProduitService(final ProduitService produitService) {

		this.produitService = produitService;
	}

	@GetMapping(value = "/produit")
	public List<Produit> listeDesProduits() {

		ProduitController.LOG.info("**** using {} : {}", this.getClass().getSimpleName(), this.hashCode());

		final List<Produit> produits = this.produitService.getProduits();

		ProduitController.LOG.info("**** done with {} : {}", this.getClass().getSimpleName(), this.hashCode());

		return produits;
	}

	@GetMapping(value = "/produit/{id}")
	public Produit recupererUnProduit(@PathVariable final Long id) {

		ProduitController.LOG.info("**** using {} : {}", this.getClass().getSimpleName(), this.hashCode());

		final Produit produit = this.produitService.getProduit(id);

		ProduitController.LOG.info("**** done with {} : {}", this.getClass().getSimpleName(), this.hashCode());

		return produit;
	}
}
