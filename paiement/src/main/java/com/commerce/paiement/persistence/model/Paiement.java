package com.commerce.paiement.persistence.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Paiement {

    @Id
    @GeneratedValue
    private Long id;
    private Long numeroCarte;
    private Integer montant;

    @Column(unique = true)
    private Long idCommande;
}
