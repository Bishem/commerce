package com.mycommerce.client.rest.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mycommerce.client.business.binder.bean.CommandeBean;
import com.mycommerce.client.business.binder.bean.PaiementBean;
import com.mycommerce.client.business.binder.bean.ProduitBean;
import com.mycommerce.client.business.service.ClientService;

@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping("")
	public String accueil(final Model model) {

		model.addAttribute("pageAcceuilForm", this.clientService.getAllProduits());

		final String view = "PageAccueil";

		return view;
	}

	@GetMapping("/pageProduit/{id}")
	public String ficheProduit(@PathVariable final Long id, final Model model) {

		model.addAttribute("pageProduitForm", this.clientService.getProduitById(id));

		final String view = "PageProduit";

		return view;
	}

	@GetMapping("/pageCommande/{idProduit}")
	public String commande(@PathVariable final Long idProduit, final Model model) {

		model.addAttribute("pageCommandeForm", this.clientService.getAllProduits());

		final String view = "PageAccueil";

		return view;
		final Optional<ProduitBean> produitBean = this.produitProxy.recupererUnProduit(idProduit);

		final CommandeBean commandeBean = new CommandeBean(new Date(), this.quantiteAleatoire(),
				produitBean.get().getId());

		final ResponseEntity<CommandeBean> commandeAjoutee = this.commandeProxy.ajouterCommande(commandeBean);

		if (commandeAjoutee.getStatusCode().equals(HttpStatus.CREATED)) {
			model.addAttribute("commande", commandeAjoutee.getBody());
		}

		return "PageCommande";
	}

	@GetMapping("/pagePaiement/{idCommande}")
	public String paiement(@PathVariable final Long idCommande, final Model model) {

		model.addAttribute("pageAcceuilForm", this.clientService.getAllProduits());

		final String view = "PageAccueil";

		return view;
		final Optional<CommandeBean> commandeBean = this.commandeProxy.recupererUneCommande(idCommande);

		final Optional<ProduitBean> produitBean = this.produitProxy
				.recupererUnProduit(commandeBean.get().getIdProduit());

		final PaiementBean paiementBean = new PaiementBean(this.numeroCarteAleatoire(),
				produitBean.get().getPrix() * commandeBean.get().getQuantite(), commandeBean.get().getId());

		final ResponseEntity<PaiementBean> paiementAjoutee = this.paiementProxy.payerUneCommande(paiementBean);

		if (paiementAjoutee.getStatusCode().equals(HttpStatus.CREATED)) {
			model.addAttribute("etatPayement", Boolean.TRUE);
		} else {
			model.addAttribute("etatPayement", Boolean.FALSE);
		}

		return "PagePaiement";
	}
}
