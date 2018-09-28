package com.commerce.client.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.commerce.client.business.service.ClientService;

@Controller
@RefreshScope
public class ClientController {

	private ClientService clientService;

	public ClientController() {

	}

	@Autowired
	public ClientController(final ClientService clientService) {

		this.clientService = clientService;
	}

	@GetMapping("")
	public ModelAndView accueil() {

		final ModelAndView mav = new ModelAndView("accueil");

		mav.addObject("produits", this.clientService.getAllProduits());

		return mav;
	}

	@GetMapping("/detailler/{id}")
	public ModelAndView ficheProduit(@PathVariable final Long id) {

		final ModelAndView mav = new ModelAndView("details");

		mav.addObject("produit", this.clientService.getProduitById(id));

		return mav;
	}

	@GetMapping("/commander/{idProduit}")
	public ModelAndView commande(@PathVariable final Long idProduit) {

		final ModelAndView mav = new ModelAndView("commande");

		mav.addObject("commande", this.clientService.getNewCommande(idProduit));

		return mav;
	}

	@GetMapping("/payer/{idCommande}")
	public ModelAndView paiement(@PathVariable final Long idCommande) {

		final ModelAndView mav = new ModelAndView("paiement");

		mav.addObject("etatPayement", this.clientService.getNewPaiement(idCommande));

		return mav;
	}
}
