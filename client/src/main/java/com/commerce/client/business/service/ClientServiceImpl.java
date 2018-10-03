package com.commerce.client.business.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger LOG = LoggerFactory.getLogger(ClientServiceImpl.class);

	private final Random random = new Random();

	private ProduitProxy	produitProxy;
	private CommandeProxy	commandeProxy;
	private PaiementProxy	paiementProxy;

	@Autowired
	public void setProduitProxy(final ProduitProxy produitProxy) {

		this.produitProxy = produitProxy;
	}

	@Autowired
	public void setCommandeProxy(final CommandeProxy commandeProxy) {

		this.commandeProxy = commandeProxy;
	}

	@Autowired
	public void setPaiementProxy(final PaiementProxy paiementProxy) {

		this.paiementProxy = paiementProxy;
	}

	@Override
	public List<ProduitBean> getAllProduits() {

		ClientServiceImpl.LOG.info("**** using {} : {}", this.getClass().getSimpleName(), this.hashCode());

		final List<ProduitBean> produitsTrouvees = this.produitProxy.listeDesProduits();

		ClientServiceImpl.LOG.info("**** done with {} : {}", this.getClass().getSimpleName(), this.hashCode());

		return produitsTrouvees;
	}

	@Override
	public ProduitBean getProduitById(final Long id) {

		ClientServiceImpl.LOG.info("**** using {} : {}", this.getClass().getSimpleName(), this.hashCode());

		final ProduitBean produitTrouvee = this.produitProxy.recupererUnProduit(id);

		ClientServiceImpl.LOG.info("**** done with {} : {}", this.getClass().getSimpleName(), this.hashCode());

		return produitTrouvee;
	}

	@Override
	public CommandeBean getNewCommande(final Long idProduit) {

		ClientServiceImpl.LOG.info("**** using {} : {}", this.getClass().getSimpleName(), this.hashCode());

		final CommandeBean commande = new CommandeBean(new Date(), this.quantiteAleatoire(), Boolean.FALSE, idProduit);
		final ResponseEntity<CommandeBean> commandeBean = this.commandeProxy.ajouterCommande(commande);
		final CommandeBean commandeAjoutee = commandeBean.getBody();

		ClientServiceImpl.LOG.info("**** done with {} : {}", this.getClass().getSimpleName(), this.hashCode());

		return commandeAjoutee;
	}

	@Override
	public Boolean getNewPaiement(final Long idCommande) {

		ClientServiceImpl.LOG.info("**** using {} : {}", this.getClass().getSimpleName(), this.hashCode());

		final CommandeBean commandeBean = this.commandeProxy.recupererUneCommande(idCommande);

		final ProduitBean produitBean = this.produitProxy.recupererUnProduit(commandeBean.getIdProduit());

		final Long numeroCarte = this.numeroCarteAleatoire();
		final double quantite = produitBean.getPrix() * commandeBean.getQuantite();
		final PaiementBean paiement = new PaiementBean(numeroCarte, quantite, idCommande);
		final ResponseEntity<PaiementBean> paiementBean = this.paiementProxy.payerUneCommande(paiement);
		final ResponseEntity<PaiementBean> paiementAjoutee = paiementBean;

		final Boolean etatPayement = this.getEtatPayement(paiementAjoutee);

		ClientServiceImpl.LOG.info("**** done with {} : {}", this.getClass().getSimpleName(), this.hashCode());

		return etatPayement;
	}

	private Boolean getEtatPayement(final ResponseEntity<PaiementBean> paiementAjoutee) {

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
