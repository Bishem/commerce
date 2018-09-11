package com.mycommerce.client.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycommerce.client.bean.ProduitBean;
import com.mycommerce.client.proxy.ProduitProxy;

@Controller
public class ClientController {

	@Autowired
	private ProduitProxy produitsProxy;

	@RequestMapping("/")
	public String accueil(final Model model) {

		final List<ProduitBean> produits = this.produitsProxy.listeDesProduits();

		model.addAttribute("produits", produits);

		return new String("Accueil");
	}

	@RequestMapping("/details-produit/{id}")
	public String ficheProduit(@PathVariable final Long id, final Model model) {

		final ProduitBean produit = this.produitsProxy.recupererUnProduit(id);

		model.addAttribute("produit", produit);

		return new String("FicheProduit");
	}
}
