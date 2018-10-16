package com.commerce.paiement.business.service;

import com.commerce.paiement.business.binder.bean.CommandeBean;
import com.commerce.paiement.business.binder.bean.ExpeditionBean;
import com.commerce.paiement.business.binder.proxy.CommandeProxy;
import com.commerce.paiement.business.binder.proxy.ExpeditionProxy;
import com.commerce.paiement.business.exception.PaiementExistantException;
import com.commerce.paiement.persistence.dao.PaiementDao;
import com.commerce.paiement.persistence.model.Paiement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PaiementServiceImpl implements PaiementService {

    private PaiementDao paiementDao;

    private CommandeProxy commandeProxy;
    private ExpeditionProxy expeditionProxy;

    @Autowired
    public void setPaiementDao(final PaiementDao paiementDao) {

        this.paiementDao = paiementDao;
    }

    @Autowired
    public void setExpeditionProxy(ExpeditionProxy expeditionProxy) {

        this.expeditionProxy = expeditionProxy;
    }

    @Autowired
    public void setCommandeProxy(CommandeProxy commandeProxy) {

        this.commandeProxy = commandeProxy;
    }

    @Override
    public Paiement postPaiement(final Paiement paiement) {

        if (this.paiementDao.findByidCommande(paiement.getIdCommande()).isPresent()) {

            throw new PaiementExistantException("La commande n°" + paiement.getIdCommande() + " est déjà payée");
        } else {

            final Paiement paiementSaved = this.paiementDao.save(paiement);

            modifierCommande(paiement);

            expeditionProxy.postExpedition(
                    new ExpeditionBean(
                            0,
                            paiementSaved.getIdCommande()));

            return paiementSaved;
        }
    }

    private void modifierCommande(Paiement paiement) {

        CommandeBean commandeFound = commandeProxy.getCommande(paiement.getIdCommande());
        commandeFound.setEstPayee(Boolean.TRUE);
        commandeProxy.patchCommande(commandeFound);
    }
}
