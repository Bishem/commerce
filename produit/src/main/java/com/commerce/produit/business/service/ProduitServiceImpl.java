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

@Service
@Transactional
public class ProduitServiceImpl implements ProduitService {

    @Value(value = "${produit.limite}")
    int limite;

    ProduitDao produitDao;

    @Autowired
    public void setProduitDao(final ProduitDao produitDao) {

        this.produitDao = produitDao;
    }

    @Override
    public List<Produit> readProduits() {

        final List<Produit> produitsRed = new ArrayList<>();
        this.produitDao.findAll().forEach(produitsRed::add);

        if (produitsRed.isEmpty()) {

            throw new ProduitIntrouvableException("Aucun produit n'est disponible à la vente");
        } else {

            return produitsRed.subList(0, this.limite);
        }
    }

    @Override
    public Produit readProduit(final Long id) {

        final Optional<Produit> produitRed = this.produitDao.findById(id);

        if (!produitRed.isPresent()) {

            throw new ProduitIntrouvableException("Le produit correspondant à l'id " + id + " n'existe pas");
        } else {

            return produitRed.get();
        }
    }
}
