package com.commerce.paiement.business.binder.bean;

import lombok.Data;

import java.util.Date;

@Data
public class CommandeBean {

    private Long id;
    private Date date;
    private Integer quantite;
    private Boolean estPayee;

    private Long idProduit;
}
