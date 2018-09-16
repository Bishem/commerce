package com.mycommerce.client.web.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycommerce.client.bean.CommandeBean;
import com.mycommerce.client.bean.PaiementBean;
import com.mycommerce.client.bean.ProduitBean;
import com.mycommerce.client.proxy.CommandeProxy;
import com.mycommerce.client.proxy.PaiementProxy;
import com.mycommerce.client.proxy.ProduitProxy;

@Controller
public class ClientController {

	@Autowired
	private ProduitProxy produitProxy;

	@Autowired
	private CommandeProxy commandeProxy;

	@Autowired
	private PaiementProxy paiementProxy;

	private final Random entropie = new Random();

	@RequestMapping("")
	public String accueil(final Model model) {

		final List<ProduitBean> produitBeans = this.produitProxy.listeDesProduits();

		model.addAttribute("produits", produitBeans);

		return new String("PageAccueil");
	}

	@RequestMapping("/pageProduit/{id}")
	public String ficheProduit(@PathVariable final Long id, final Model model) {

		final Optional<ProduitBean> produitBean = this.produitProxy.recupererUnProduit(id);

		if (produitBean.isPresent()) {
			model.addAttribute("produit", produitBean.get());
		}

		return new String("PageProduit");
	}

	@RequestMapping("/pageCommande/{idProduit}")
	public String commande(@PathVariable final Long idProduit, final Model model) {

		final Optional<ProduitBean> produitBean = this.produitProxy.recupererUnProduit(idProduit);

		final CommandeBean commandeBean = new CommandeBean(new Date(), this.quantiteAleatoire(),
				produitBean.get().getId());

		final ResponseEntity<CommandeBean> commandeAjoutee = this.commandeProxy.ajouterCommande(commandeBean);

		if (commandeAjoutee.getStatusCode().equals(HttpStatus.CREATED)) {
			model.addAttribute("commande", commandeAjoutee);
		}

		return new String("PageCommande");
	}

	@RequestMapping("/pagePaiement/{idCommande}")
	public String paiement(@PathVariable final Long idCommande, final Model model) {

		final Optional<CommandeBean> commandeBean = this.commandeProxy.recupererUneCommande(idCommande);

		final Optional<ProduitBean> produitBean = this.produitProxy
				.recupererUnProduit(commandeBean.get().getIdProduit());

		final PaiementBean paiementBean = new PaiementBean(this.numeroCarteAleatoire(),
				produitBean.get().getPrix() * commandeBean.get().getQuantite(), commandeBean.get().getId());

		final ResponseEntity<PaiementBean> paiementAjoutee = this.paiementProxy.payerUneCommande(paiementBean);

		if (paiementAjoutee.getStatusCode().equals(HttpStatus.CREATED)) {
			model.addAttribute("etatPayement", true);
		} else {
			model.addAttribute("etatPayement", false);
		}

		return new String("PagePaiement");
	}

	private Integer quantiteAleatoire() {

		return (int) (this.entropie.nextInt(10) + 10);
	}

	private Long numeroCarteAleatoire() {

		return (long) (this.entropie.nextInt(1000000000) + 1000000000);
	}
}
