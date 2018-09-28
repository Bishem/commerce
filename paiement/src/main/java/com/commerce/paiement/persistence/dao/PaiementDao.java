package com.commerce.paiement.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.commerce.paiement.persistence.model.Paiement;

@RepositoryRestResource
public interface PaiementDao extends JpaRepository<Paiement, Long> {

	Paiement findByidCommande(Long idCommande);
}
