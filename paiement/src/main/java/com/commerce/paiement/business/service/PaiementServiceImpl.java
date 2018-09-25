package com.commerce.paiement.business.service;

import java.util.Optional;

import javax.transaction.Transactional;

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

	@Autowired
	private PaiementDao paiementDao;

	@Autowired
	private CommandeProxy commandeProxy;

	@Override
	public Paiement postPaiement(final Paiement paiement) {

		this.testerSiDejaPayee(paiement);

		final Paiement paiementAjoutee = this.paiementDao.save(paiement);

		this.mettreAJourCommande(paiement);

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
