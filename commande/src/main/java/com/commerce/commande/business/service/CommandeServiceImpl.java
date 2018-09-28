package com.commerce.commande.business.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commerce.commande.business.exception.CommandeIntrouvableException;
import com.commerce.commande.persistence.dao.CommandeDao;
import com.commerce.commande.persistence.model.Commande;

@Transactional
@Service
public class CommandeServiceImpl implements CommandeService {

	private static final Logger LOG = LoggerFactory.getLogger(CommandeServiceImpl.class);

	private CommandeDao commandeDao;

	public CommandeServiceImpl() {

	}

	@Autowired
	public CommandeServiceImpl(final CommandeDao commandeDao) {

		this.commandeDao = commandeDao;
	}

	@Override
	public Optional<Commande> getCommande(final Long id) {

		CommandeServiceImpl.LOG.info("**** using {} : {}", this.getClass().getSimpleName(), this.hashCode());

		final Optional<Commande> commandeCherchee = this.commandeDao.findById(id);

		if (!commandeCherchee.isPresent()) {
			throw new CommandeIntrouvableException("Cette commande n'existe pas");
		} else {

			CommandeServiceImpl.LOG.info("**** done with {} : {}", this.getClass().getSimpleName(), this.hashCode());

			return commandeCherchee;
		}
	}

	@Override
	public Commande postCommande(final Commande commande) {

		CommandeServiceImpl.LOG.info("**** using {} : {}", this.getClass().getSimpleName(), this.hashCode());

		final Commande commandePosted = this.commandeDao.save(commande);

		CommandeServiceImpl.LOG.info("**** done with {} : {}", this.getClass().getSimpleName(), this.hashCode());

		return commandePosted;
	}

	@Override
	public Commande putCommande(final Commande commande) {

		CommandeServiceImpl.LOG.info("**** using {} : {}", this.getClass().getSimpleName(), this.hashCode());

		final Commande commandePut = this.commandeDao.save(commande);

		CommandeServiceImpl.LOG.info("**** done with {} : {}", this.getClass().getSimpleName(), this.hashCode());

		return commandePut;
	}
}
