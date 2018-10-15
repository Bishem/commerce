package com.commerce.expedition.persistence.dao;

import com.commerce.expedition.persistence.model.Expedition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpeditionDao extends CrudRepository<Expedition, Long> {

    Optional<Expedition> findByIdCommande(Long idCommande);
}
