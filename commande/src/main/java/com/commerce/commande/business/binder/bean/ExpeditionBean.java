package com.commerce.commande.business.binder.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExpeditionBean {

    private Long id;
    private Integer etat;

    private Long idCommande;
}
