package com.mycommerce.client.business.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mycommerce.client.business.binder.bean.CommandeBean;
import com.mycommerce.client.business.binder.bean.PaiementBean;
import com.mycommerce.client.business.binder.bean.ProduitBean;
import com.mycommerce.client.business.binder.proxy.CommandeProxy;
import com.mycommerce.client.business.binder.proxy.PaiementProxy;
import com.mycommerce.client.business.binder.proxy.ProduitProxy;
import com.mycommerce.client.rest.form.PageCommandeForm;
import com.mycommerce.client.rest.form.PagePaiementForm;
import com.mycommerce.client.rest.form.PageProduitForm;

@Service
public class ClientService {

	private final Random random;

	@Autowired
	private ProduitProxy produitProxy;

	@Autowired
	private CommandeProxy commandeProxy;

	@Autowired
	private PaiementProxy paiementProxy;

	public ClientService() {

		this.random = new Random();
	}

	public List<ProduitBean> getAllProduits() {

		return this.produitProxy.listeDesProduits();
	}

	public PageProduitForm getProduitById(final Long id) {

		return new PageProduitForm(this.produitProxy.recupererUnProduit(id));
	}

	public PageCommandeForm getNewCommande(final Long idProduit) {

		return new PageCommandeForm(
				this.commandeProxy.ajouterCommande(
						new CommandeBean(
								new Date(),
								this.quantiteAleatoire(),
								idProduit)));
	}

	public PagePaiementForm getNewPaiement(final Long idCommande) {

		final Optional<CommandeBean> commandeBean = this.commandeProxy.recupererUneCommande(idCommande);

		final Optional<ProduitBean> produitBean = this.produitProxy.recupererUnProduit(commandeBean.get().getIdProduit());

		final ResponseEntity<PaiementBean> paiementAjoutee = this.paiementProxy.payerUneCommande(
				new PaiementBean(
						this.numeroCarteAleatoire(),
						produitBean.get().getPrix() * commandeBean.get().getQuantite(),
						commandeBean.get().getId()));

		if (paiementAjoutee.getStatusCode().equals(HttpStatus.CREATED)) {
			return new PagePaiementForm(Boolean.TRUE);
		} else {
			return new PagePaiementForm(Boolean.FALSE);
		}
	}

	private Integer quantiteAleatoire() {

		return this.random.nextInt(10) + 10;
	}

	private Long numeroCarteAleatoire() {

		return (long) (this.random.nextInt(1000000000) + 1000000000);
	}

}
