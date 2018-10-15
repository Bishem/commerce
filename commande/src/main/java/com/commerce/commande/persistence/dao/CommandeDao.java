package com.commerce.commande.persistence.dao;

import com.commerce.commande.persistence.model.Commande;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeDao extends CrudRepository<Commande, Long> {

}
