package com.commerce.paiement.business.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.commerce.paiement.business.binder.bean.CommandeBean;
import com.commerce.paiement.business.binder.proxy.CommandeProxy;
import com.commerce.paiement.business.exception.PaiementExistantException;
import com.commerce.paiement.business.exception.PaiementImpossibleException;
import com.commerce.paiement.persistence.dao.PaiementDao;
import com.commerce.paiement.persistence.model.Paiement;

@Transactional
@Service
public class PaiementServiceImpl implements PaiementService {

	private static final Logger LOG = LoggerFactory.getLogger(PaiementServiceImpl.class);

	private PaiementDao		paiementDao;
	private CommandeProxy	commandeProxy;

	@Autowired
	public void setPaiementDao(final PaiementDao paiementDao) {

		this.paiementDao = paiementDao;
	}

	@Autowired
	public void setCommandeProxy(final CommandeProxy commandeProxy) {

		this.commandeProxy = commandeProxy;
	}

	@Override
	public Paiement postPaiement(final Paiement paiement) {

		PaiementServiceImpl.LOG.info("**** using {} : {}", this.getClass().getSimpleName(), this.hashCode());

		this.testerSiExiste(paiement);

		final Paiement paiementPosted = this.paiementDao.save(paiement);

		this.mettreAJourCommande(paiement.getIdCommande());

		PaiementServiceImpl.LOG.info("**** done with {} : {}", this.getClass().getSimpleName(), this.hashCode());

		return paiementPosted;

	}

	private void testerSiExiste(final Paiement paiement) {

		final Paiement paiementFound = this.paiementDao.findByidCommande(paiement.getIdCommande());

		if (paiementFound != null) {

			throw new PaiementExistantException("Cette commande est déjà payée");
		}
	}

	private void mettreAJourCommande(final Long idCommande) {

		final CommandeBean commandeRecuperee = this.commandeProxy.recupererUneCommande(idCommande);

		commandeRecuperee.setEstPayee(Boolean.TRUE);

		final ResponseEntity<CommandeBean> commandeUpdated = this.commandeProxy.updateCommande(commandeRecuperee);

		if (!commandeUpdated.getStatusCode().equals(HttpStatus.CREATED)) {

			throw new PaiementImpossibleException("La commande n°" + idCommande + " de ce paiement n'as pas pu être validée");
		}
	}
}
