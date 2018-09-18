package com.mycommerce.client.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String ficheProduit(@PathVariable final Long id, final Model model) {

		model.addAttribute("pageProduitForm", this.clientService.getProduitById(id));

		return "PageProduit";
	}

	@GetMapping("/pageCommande/{idProduit}")
	public String commande(@PathVariable final Long idProduit, final Model model) {

		model.addAttribute("pageCommandeForm", this.clientService.getNewCommande(idProduit));

		return "PageCommande";
	}

	@GetMapping("/pagePaiement/{idCommande}")
	public String paiement(@PathVariable final Long idCommande, final Model model) {

		model.addAttribute("pagePaiementForm", this.clientService.getNewPaiement(idCommande));

		return "PagePaiement";
	}
}
