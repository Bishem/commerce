package com.mycommerce.paiement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycommerce.paiement.model.Paiement;

@Repository
public interface PaiementDao extends JpaRepository<Paiement, Long> {

	Paiement findByidCommande(Long idCommande);

}
