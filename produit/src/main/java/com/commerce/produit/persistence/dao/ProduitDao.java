package com.commerce.produit.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.commerce.produit.persistence.model.Produit;

@Repository
public interface ProduitDao extends JpaRepository<Produit, Long> {
}
