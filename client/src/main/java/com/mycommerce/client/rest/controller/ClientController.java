package com.mycommerce.client.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.mycommerce.client.business.service.ClientService;

@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping("")
	public ModelAndView accueil() {

		final ModelAndView mav = new ModelAndView("PageAccueil");

		mav.addObject("produits", this.clientService.getAllProduits());

		return mav;
	}

	@GetMapping("/pageProduit/{id}")
	public ModelAndView ficheProduit(@PathVariable final Long id) {

		final ModelAndView mav = new ModelAndView("PageProduit");

		mav.addObject("produit", this.clientService.getProduitById(id));

		return mav;
	}

	@GetMapping("/pageCommande/{idProduit}")
	public ModelAndView commande(@PathVariable final Long idProduit) {

		final ModelAndView mav = new ModelAndView("PageCommande");

		mav.addObject("commande", this.clientService.getNewCommande(idProduit));

		return mav;
	}

	@GetMapping("/pagePaiement/{idCommande}")
	public ModelAndView paiement(@PathVariable final Long idCommande) {

		final ModelAndView mav = new ModelAndView("PagePaiement");

		mav.addObject("etatPayement", this.clientService.getNewPaiement(idCommande));

		return mav;
	}
}
