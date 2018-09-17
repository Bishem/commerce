package com.mycommerce.produit.persistence.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mycommerce.produit.persistence.model.Produit;

@Component
public class DbSeeder implements CommandLineRunner {

	private ProduitDao produitDao;

	public DbSeeder() {

	}

	@Autowired
	public void setProduitDao(final ProduitDao produitDao) {

		this.produitDao = produitDao;
	}

	@Override
	public void run(final String... args) throws Exception {

		this.produitDao.save(new Produit(Long.valueOf(0), "Bougie fonctionnant au feu",
				"bougie qui fonctionne comme une ampoule mais sans électricité !",
				"https://s3.eu-west-3.amazonaws.com/oc-images-cours/bougies.jpg", 22.0));
		this.produitDao.save(
				new Produit(Long.valueOf(1), "Chaise pour s'assoir", "Chaise rare avec non pas 1 ni 2 mais 3 pieds",
						"https://s3.eu-west-3.amazonaws.com/oc-images-cours/chaise.jpg", 95.0));
		this.produitDao.save(new Produit(Long.valueOf(2), "Cheval pour nains",
				"Ce cheval ne portera certainement pas blanche neige, mais sans problème les nains",
				"https://s3.eu-west-3.amazonaws.com/oc-images-cours/cheval.jpg", 360.0));
		this.produitDao.save(new Produit(Long.valueOf(3), "Coq of steel, le superman des volailles",
				"Ne passe pas au four", "https://s3.eu-west-3.amazonaws.com/oc-images-cours/coq.jpg", 620.0));
		this.produitDao.save(new Produit(Long.valueOf(4), "Flacon à frotter avec un génie dedans",
				"Vous donne droit à l'équivalent de 3/0 voeux",
				"https://s3.eu-west-3.amazonaws.com/oc-images-cours/flacon.jpg", 1200.0));
		this.produitDao.save(new Produit(Long.valueOf(5), "Horloge quantique",
				"Donne l'heure, les minutes et même les secondes. Ne fait pas de café",
				"https://s3.eu-west-3.amazonaws.com/oc-images-cours/horloge.jpg", 180.0));
		this.produitDao.save(new Produit(Long.valueOf(6), "Table d'opération pour Hamsters",
				"Pour réaliser vos opérations chirugicales sur votre Hamster!",
				"https://s3.eu-west-3.amazonaws.com/oc-images-cours/table.jpg", 210.0));
		this.produitDao.save(new Produit(Long.valueOf(7), "Vase ayant appartenu a Zeus", "Risque de choc électrique",
				"https://s3.eu-west-3.amazonaws.com/oc-images-cours/vase.jpg", 730.0));
	}

}