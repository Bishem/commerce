package com.commerce.expedition.business.service;

import com.commerce.expedition.business.exception.ExpeditionExistanteException;
import com.commerce.expedition.business.exception.ExpeditionIntrouvableException;
import com.commerce.expedition.persistence.dao.ExpeditionDao;
import com.commerce.expedition.persistence.model.Expedition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class ExpeditionServiceImpl implements ExpeditionService {

    private ExpeditionDao expeditionDao;

    @Autowired
    public void setExpeditionDao(final ExpeditionDao expeditionDao) {

        this.expeditionDao = expeditionDao;
    }

    @Override
    public Expedition getExpedition(final Long id) {

        final Optional<Expedition> expeditionFound = this.expeditionDao.findById(id);

        if (!expeditionFound.isPresent()) {

            throw new ExpeditionIntrouvableException("L'expedition n°" + id + "n'existe pas");
        } else {

            return expeditionFound.get();
        }
    }

    @Override
    public Expedition postExpedition(final Expedition expedition) {

        if (expeditionDao.findByIdCommande(expedition.getIdCommande()).isPresent()) {

            throw new ExpeditionExistanteException("La commande n°" + expedition.getIdCommande() + "est deja expediee");
        } else {

            return this.expeditionDao.save(expedition);
        }
    }

    @Override
    public Expedition patchExpedition(final Expedition expedition) {


        if (!expeditionDao.findByIdCommande(expedition.getIdCommande()).isPresent()) {

            throw new ExpeditionIntrouvableException("La commande n°" + expedition.getIdCommande() + " n'as jamais ete expediee");
        } else {

            return this.expeditionDao.save(expedition);
        }
    }
}
