package com.mycommerce.paiement.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycommerce.paiement.persistence.model.Paiement;

@Repository
public interface PaiementDao extends JpaRepository<Paiement, Long> {

	Paiement findByidCommande(Long idCommande);

}
