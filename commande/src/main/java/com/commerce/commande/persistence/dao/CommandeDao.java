package com.commerce.commande.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.commerce.commande.persistence.model.Commande;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {
}
