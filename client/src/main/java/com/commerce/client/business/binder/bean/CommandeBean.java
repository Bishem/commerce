package com.commerce.client.business.binder.bean;

import java.util.Date;

public class CommandeBean {

    private Long id;
    private Date date;
    private Integer quantite;
    private Boolean estPayee;

    private Long idProduit;

    public CommandeBean() {

    }

    public CommandeBean(final Date date, final Integer quantite, final Boolean estPayee, final Long idProduit) {

        this.date = date;
        this.quantite = quantite;
        this.estPayee = estPayee;
        this.idProduit = idProduit;
    }

    public CommandeBean(final Long id, final Date date, final Integer quantite, final Boolean estPayee,
                        final Long idProduit) {

        this.id = id;
        this.date = date;
        this.quantite = quantite;
        this.estPayee = estPayee;
        this.idProduit = idProduit;
    }

    public Long getId() {

        return this.id;
    }

    public void setId(final Long id) {

        this.id = id;
    }

    public Date getDate() {

        return this.date;
    }

    public void setDate(final Date date) {

        this.date = date;
    }

    public Boolean getEstPayee() {

        return this.estPayee;
    }

    public void setEstPayee(final Boolean estPayee) {

        this.estPayee = estPayee;
    }

    public Long getIdProduit() {

        return this.idProduit;
    }

    public void setIdProduit(final Long idProduit) {

        this.idProduit = idProduit;
    }

    public Integer getQuantite() {

        return this.quantite;
    }

    public void setQuantite(final Integer quantite) {

        this.quantite = quantite;
    }

    @Override
    public String toString() {

        return "CommandeBean{" + "id=" + this.id + ", date=" + this.date + ", quantite=" + this.quantite + ", estPayee="
                + this.estPayee + ", idProduit=" + this.idProduit + '}';
    }
}
