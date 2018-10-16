package com.commerce.client.business.binder.bean;

import lombok.Data;

@Data
public class PaiementBean {

    private Long id;
    private Long numeroCarte;
    private Double montant;

    private Long idCommande;

    public PaiementBean(final Long numeroCarte, final Double montant, final Long idCommande) {

        this.montant = montant;
        this.numeroCarte = numeroCarte;
        this.idCommande = idCommande;
    }
}
