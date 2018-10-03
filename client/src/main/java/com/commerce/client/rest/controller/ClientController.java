package com.commerce.client.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.commerce.client.business.service.ClientService;

@Controller
public class ClientController {

	private static final Logger LOG = LoggerFactory.getLogger(ClientController.class);

	private ClientService clientService;

	@Autowired
	public void setClientService(final ClientService clientService) {

		this.clientService = clientService;
	}

	@GetMapping("")
	public ModelAndView accueil() {

		ClientController.LOG.info("**** using {} : {}", this.getClass().getSimpleName(), this.hashCode());

		final ModelAndView mav = new ModelAndView("accueil");

		mav.addObject("produits", this.clientService.getAllProduits());

		ClientController.LOG.info("**** done with {} : {}", this.getClass().getSimpleName(), this.hashCode());

		return mav;
	}

	@GetMapping("/detailler/{id}")
	public ModelAndView ficheProduit(@PathVariable final Long id) {

		ClientController.LOG.info("**** using {} : {}", this.getClass().getSimpleName(), this.hashCode());

		final ModelAndView mav = new ModelAndView("details");

		mav.addObject("produit", this.clientService.getProduitById(id));

		ClientController.LOG.info("**** done with {} : {}", this.getClass().getSimpleName(), this.hashCode());

		return mav;
	}

	@GetMapping("/commander/{idProduit}")
	public ModelAndView commande(@PathVariable final Long idProduit) {

		ClientController.LOG.info("**** using {} : {}", this.getClass().getSimpleName(), this.hashCode());

		final ModelAndView mav = new ModelAndView("commande");

		mav.addObject("commande", this.clientService.getNewCommande(idProduit));

		ClientController.LOG.info("**** done with {} : {}", this.getClass().getSimpleName(), this.hashCode());

		return mav;
	}

	@GetMapping("/payer/{idCommande}")
	public ModelAndView paiement(@PathVariable final Long idCommande) {

		ClientController.LOG.info("**** using {} : {}", this.getClass().getSimpleName(), this.hashCode());

		final ModelAndView mav = new ModelAndView("paiement");

		mav.addObject("etatPayement", this.clientService.getNewPaiement(idCommande));

		ClientController.LOG.info("**** done with {} : {}", this.getClass().getSimpleName(), this.hashCode());

		return mav;
	}
}
