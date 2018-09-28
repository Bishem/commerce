package com.commerce.commande.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.commerce.commande.persistence.model.Commande;

@RepositoryRestResource
public interface CommandeDao extends JpaRepository<Commande, Long> {

}
