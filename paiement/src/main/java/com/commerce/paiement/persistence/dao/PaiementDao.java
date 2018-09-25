package com.commerce.paiement.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.commerce.paiement.persistence.model.Paiement;

@Repository
public interface PaiementDao extends JpaRepository<Paiement, Long> {

	Paiement findByidCommande(Long idCommande);

}
