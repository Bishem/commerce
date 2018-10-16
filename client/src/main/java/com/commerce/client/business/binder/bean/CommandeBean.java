package com.commerce.client.business.binder.bean;

import lombok.Data;

import java.util.Date;

@Data
public class CommandeBean {

    private Long id;
    private Date date;
    private Integer quantite;
    private Boolean estPayee;

    private Long idProduit;

    public CommandeBean(final Date date, final Integer quantite, final Boolean estPayee, final Long idProduit) {

        this.date = date;
        this.quantite = quantite;
        this.estPayee = estPayee;
        this.idProduit = idProduit;
    }
}
