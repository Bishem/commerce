package com.commerce.produit.business.service;

import com.commerce.produit.business.exception.ProduitIntrouvableException;
import com.commerce.produit.persistence.dao.ProduitDao;
import com.commerce.produit.persistence.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProduitServiceImpl implements ProduitService {

    @Value(value = "${produit.limite}")
    int limite;

    ProduitDao produitDao;

    @Autowired
    public void setProduitDao(final ProduitDao produitDao) {

        this.produitDao = produitDao;
    }

    @Override
    public List<Produit> getProduits() {

        final List<Produit> produitsFound = new ArrayList<>();
        this.produitDao.findAll().forEach(produitsFound::add);
//        this.produitDao.findAll().forEach( produit -> produitsFound.add(produit));

        if (produitsFound.isEmpty()) {

            throw new ProduitIntrouvableException("Aucun produit n'est disponible à la vente");
        } else {

            return produitsFound.subList(0, this.limite);
        }
    }

    @Override
    public Produit getProduit(final Long id) {

        final Optional<Produit> produitFound = this.produitDao.findById(id);

        if (!produitFound.isPresent()) {

            throw new ProduitIntrouvableException("Le produit correspondant à l'id " + id + " n'existe pas");
        } else {

            return produitFound.get();
        }
    }
}
