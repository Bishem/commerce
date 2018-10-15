package com.commerce.client.business.binder.bean;

public class ExpeditionBean {

    private Long    id;
    private Integer idCommande;
    private Integer etat;

    public ExpeditionBean() {

    }

    public ExpeditionBean(final Integer idCommande, final Integer etat) {

        this.idCommande = idCommande;
        this.etat = etat;
    }

    public ExpeditionBean(final Long id, final Integer idCommande, final Integer etat) {

        this.id = id;
        this.idCommande = idCommande;
        this.etat = etat;
    }

    public Long getId() {

        return this.id;
    }

    public void setId(final Long id) {

        this.id = id;
    }

    public Integer getIdCommande() {

        return this.idCommande;
    }

    public void setIdCommande(final Integer idCommande) {

        this.idCommande = idCommande;
    }

    public Integer getEtat() {

        return this.etat;
    }

    public void setEtat(final Integer etat) {

        this.etat = etat;
    }

    @Override
    public String toString() {

        return "ExpeditionBean{" +
                "id=" + this.id +
                ", idCommande=" + this.idCommande +
                ", etat=" + this.etat +
                '}';
    }
}
