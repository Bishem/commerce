package com.commerce.commande.business.binder.bean;

import lombok.Data;

@Data
public class ExpeditionBean {

    private Long id;
    private Integer etat;

    private Long idCommande;
}
