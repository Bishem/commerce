package com.commerce.paiement.business.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commerce.paiement.business.binder.bean.CommandeBean;
import com.commerce.paiement.business.binder.proxy.CommandeProxy;
import com.commerce.paiement.business.exception.PaiementExistantException;
import com.commerce.paiement.persistence.dao.PaiementDao;
import com.commerce.paiement.persistence.model.Paiement;

@Transactional
@Service
public class PaiementServiceImpl implements PaiementService {

	private static final Logger LOG = LoggerFactory.getLogger(PaiementServiceImpl.class);

	private PaiementDao		paiementDao;
	private CommandeProxy	commandeProxy;

	public PaiementServiceImpl() {

	}

	@Autowired
	public PaiementServiceImpl(final PaiementDao paiementDao, final CommandeProxy commandeProxy) {

		this.paiementDao = paiementDao;
		this.commandeProxy = commandeProxy;
	}

	@Override
	public Paiement postPaiement(final Paiement paiement) {

		PaiementServiceImpl.LOG.info("**** using {} : {}", this.getClass().getSimpleName(), this.hashCode());

		this.testerSiDejaPayee(paiement);

		final Paiement paiementAjoutee = this.paiementDao.save(paiement);

		this.mettreAJourCommande(paiement);

		PaiementServiceImpl.LOG.info("**** done with {} : {}", this.getClass().getSimpleName(), this.hashCode());

		return paiementAjoutee;
	}

	private void testerSiDejaPayee(final Paiement paiement) {

		final Paiement paiementRecupere = this.paiementDao.findByidCommande(paiement.getIdCommande());

		if (paiementRecupere != null) {
			throw new PaiementExistantException("Cette commande est déjà payée");
		}
	}

	private void mettreAJourCommande(final Paiement paiement) {

		final Optional<CommandeBean> commandeRecuperee = this.commandeProxy
				.recupererUneCommande(paiement.getIdCommande());

		commandeRecuperee.get().setEstPayee(true);

		this.commandeProxy.updateCommande(commandeRecuperee.get());
	}
}
