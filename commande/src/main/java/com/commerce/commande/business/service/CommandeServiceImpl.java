package com.commerce.commande.business.service;

import com.commerce.commande.business.binder.bean.ExpeditionBean;
import com.commerce.commande.business.binder.proxy.ExpeditionProxy;
import com.commerce.commande.business.exception.CommandeExistanteException;
import com.commerce.commande.business.exception.CommandeIntrouvableException;
import com.commerce.commande.persistence.dao.CommandeDao;
import com.commerce.commande.persistence.model.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CommandeServiceImpl implements CommandeService {

    private CommandeDao commandeDao;

    @Autowired
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
    public Commande readCommande(final Long id) {

        final Optional<Commande> commandeRed = this.commandeDao.findById(id);

        if (!commandeRed.isPresent()) {

            throw new CommandeIntrouvableException("La commande n°" + id + " n'existe pas");
        } else {

            return commandeRed.get();
        }
    }

    @Override
    public Commande createCommande(final Commande commande) {

        if (commandeDao.findById(commande.getId()).isPresent()) {

            throw new CommandeExistanteException("La commande n°" + commande.getId() + " existe deja");
        } else {

            return this.commandeDao.save(commande);
        }
    }

    @Override
    public Commande updateCommande(final Commande commande) {

        if (!commandeDao.findById(commande.getId()).isPresent()) {

            throw new CommandeIntrouvableException("La commande n°" + commande.getId() + " n'existe pas");
        } else {

            Commande commandeSaved = this.commandeDao.save(commande);

            modifierExpedition(commande);

            return commandeSaved;
        }
    }

    private void modifierExpedition(Commande commande) {

        ExpeditionBean expeditionFound = expeditionProxy.getExpedition(commande.getId());
        expeditionFound.setEtat(1);
        expeditionProxy.patchExpedition(expeditionFound);
    }
}
