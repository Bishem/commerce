package com.mycommerce.produit.business.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycommerce.produit.business.configuration.AppPropsConfiguration;
import com.mycommerce.produit.business.exception.ProduitIntrouvableException;
import com.mycommerce.produit.persistence.dao.ProduitDao;
import com.mycommerce.produit.persistence.model.Produit;

public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitDao produitDao;

	@Autowired
	AppPropsConfiguration appProps;

	@Override
	public List<Produit> getProduits() {

		final List<Produit> produits = this.produitDao.findAll();

		if (produits.isEmpty()) {
			throw new ProduitIntrouvableException("Aucun produit n'est disponible à la vente");
		}

		final List<Produit> produitsLimites = produits.subList(0, this.appProps.getLimiteDeProduits());

		return produitsLimites;
	}

	@Override
	public Optional<Produit> getProduit(final Long id) {

		final Optional<Produit> produit = this.produitDao.findById(id);

		if (!produit.isPresent()) {
			throw new ProduitIntrouvableException("Le produit correspondant à l'id " + id + " n'existe pas");
		}

		return produit;
	}

}
