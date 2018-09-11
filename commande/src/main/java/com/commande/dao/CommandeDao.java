package com.commande.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.commande.model.Commande;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {
}
