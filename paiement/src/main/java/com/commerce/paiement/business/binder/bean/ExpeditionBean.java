package com.commerce.paiement.business.binder.bean;

import lombok.Data;

@Data
public class ExpeditionBean {

    private Long id;
    private Integer etat;

    private Long idCommande;

    public ExpeditionBean(Integer etat, Long idCommande) {

        this.etat = etat;
        this.idCommande = idCommande;
    }
}
