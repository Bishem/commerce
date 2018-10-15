package com.commerce.paiement.persistence.dao;

import com.commerce.paiement.persistence.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaiementDao extends JpaRepository<Paiement, Long> {

    Optional<Paiement> findByidCommande(Long idCommande);
}
