package com.commerce.client.business.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.commerce.client.business.binder.bean.CommandeBean;
import com.commerce.client.business.binder.bean.PaiementBean;
import com.commerce.client.business.binder.bean.ProduitBean;
import com.commerce.client.business.binder.proxy.CommandeProxy;
import com.commerce.client.business.binder.proxy.PaiementProxy;
import com.commerce.client.business.binder.proxy.ProduitProxy;

@Service
public class ClientServiceImpl implements ClientService {

	private final Random random = new Random();

	private ProduitProxy	produitProxy;
	private CommandeProxy	commandeProxy;
	private PaiementProxy	paiementProxy;

	public ClientServiceImpl() {

	}

	@Autowired
	public ClientServiceImpl(final ProduitProxy produitProxy, final CommandeProxy commandeProxy, final PaiementProxy paiementProxy) {

		this.produitProxy = produitProxy;
		this.commandeProxy = commandeProxy;
		this.paiementProxy = paiementProxy;
	}

	@Override
	public List<ProduitBean> getAllProduits() {

		return this.produitProxy.listeDesProduits();
	}

	@Override
	public ProduitBean getProduitById(final Long id) {

		return this.produitProxy.recupererUnProduit(id).get();
	}

	@Override
	public CommandeBean getNewCommande(final Long idProduit) {

		return this.commandeProxy.ajouterCommande(
				new CommandeBean(
						new Date(),
						this.quantiteAleatoire(),
						idProduit))
				.getBody();
	}

	@Override
	public Boolean getNewPaiement(final Long idCommande) {

		final Optional<CommandeBean> commandeBean = this.commandeProxy.recupererUneCommande(idCommande);

		final Optional<ProduitBean> produitBean = this.produitProxy.recupererUnProduit(commandeBean.get().getIdProduit());

		final ResponseEntity<PaiementBean> paiementAjoutee = this.paiementProxy.payerUneCommande(
				new PaiementBean(
						this.numeroCarteAleatoire(),
						produitBean.get().getPrix() * commandeBean.get().getQuantite(),
						idCommande));

		if (paiementAjoutee.getStatusCode().equals(HttpStatus.CREATED)) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	private Integer quantiteAleatoire() {

		return this.random.nextInt(10) + 10;
	}

	private Long numeroCarteAleatoire() {

		return (long) (this.random.nextInt(1000000000) + 1000000000);
	}
}
