package com.commerce.produit.rest.controller;

import com.commerce.produit.business.service.ProduitService;
import com.commerce.produit.persistence.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProduitController {

    ProduitService produitService;

    @Autowired
    public void setProduitService(final ProduitService produitService) {

        this.produitService = produitService;
    }

    @GetMapping(value = "/produit")
    public List<Produit> getProduits() {

        return this.produitService.readProduits();
    }

    @GetMapping(value = "/produit/{id}")
    public Produit getProduit(@PathVariable(value = "id") final Long id) {

        return this.produitService.readProduit(id);
    }
}
