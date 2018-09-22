package com.mycommerce.commande.business.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycommerce.commande.business.exception.CommandeIntrouvableException;
import com.mycommerce.commande.persistence.dao.CommandeDao;
import com.mycommerce.commande.persistence.model.Commande;

@Service
@Transactional
public class CommandeServiceImpl implements CommandeService {

	@Autowired
	private CommandeDao commandeDao;

	@Override
	public Optional<Commande> getCommande(final Long id) {

		final Optional<Commande> commandeCherchee = this.commandeDao.findById(id);

		if (!commandeCherchee.isPresent()) {
			throw new CommandeIntrouvableException("Cette commande n'existe pas");
		} else {
			return commandeCherchee;
		}
	}

	@Override
	public Commande postCommande(final Commande commande) {

		return this.commandeDao.save(commande);
	}

	@Override
	public Commande putCommande(final Commande commande) {

		return this.commandeDao.save(commande);
	}
}
