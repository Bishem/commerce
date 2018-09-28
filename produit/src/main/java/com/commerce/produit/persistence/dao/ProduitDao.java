package com.commerce.produit.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.commerce.produit.persistence.model.Produit;

@RepositoryRestResource
public interface ProduitDao extends JpaRepository<Produit, Long> {

}
