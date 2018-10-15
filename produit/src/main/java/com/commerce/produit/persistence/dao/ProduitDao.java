package com.commerce.produit.persistence.dao;

import com.commerce.produit.persistence.model.Produit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitDao extends CrudRepository<Produit, Long> {

}
