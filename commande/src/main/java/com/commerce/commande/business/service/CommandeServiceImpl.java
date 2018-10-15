package com.commerce.commande.business.service;

import com.commerce.commande.business.binder.proxy.ExpeditionProxy;
import com.commerce.commande.business.exception.CommandeExistanteException;
import com.commerce.commande.business.exception.CommandeImpossibleException;
import com.commerce.commande.business.exception.CommandeIntrouvableException;
import com.commerce.commande.persistence.dao.CommandeDao;
import com.commerce.commande.persistence.model.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class CommandeServiceImpl implements CommandeService {

    private CommandeDao commandeDao;

    private ExpeditionProxy expeditionProxy;

    @Autowired
    public void setCommandeDao(final CommandeDao commandeDao) {

        this.commandeDao = commandeDao;
    }

    @Autowired
    public void setExpeditionProxy(ExpeditionProxy expeditionProxy) {

        this.expeditionProxy = expeditionProxy;
    }

    @Override
    public Commande getCommande(final Long id) {

        final Optional<Commande> commandeFound = this.commandeDao.findById(id);

        if (!commandeFound.isPresent()) {

            throw new CommandeIntrouvableException("La commande n°" + id + " n'existe pas");
        } else {

            return commandeFound.get();
        }
    }

    @Override
    public Commande postCommande(final Commande commande) {

        if (commandeDao.findById(commande.getId()).isPresent()) {

            throw new CommandeExistanteException("La commande n°" + commande.getId() + " existe deja");
        } else {

            return this.commandeDao.save(commande);
        }
    }

    @Override
    public Commande patchCommande(final Commande commande) {

        if (!commandeDao.findById(commande.getId()).isPresent()) {

            throw new CommandeIntrouvableException("La commande n°" + commande.getId() + " n'existe pas");
        } else {

            Commande commandePatched = this.commandeDao.save(commande);

            try {

                /* TODO make find by idCommande in expedition microservice
                * change proxies that uses it (this one obviously) accordingly
                * */
                expeditionProxy.lookForOneExpedition(null);

                return commandePatched;
            }catch (Exception e) {

                throw new CommandeImpossibleException("La commande n°" + commande.getId() + " n'as pas pu etre validee");
            }
        }
    }
}
