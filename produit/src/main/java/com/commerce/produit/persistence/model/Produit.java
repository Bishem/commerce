package com.commerce.produit.persistence.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Produit {

    @Id
    @GeneratedValue
    private Long id;
    private String titre;
    private String description;
    private String image;
    private Double prix;

    public Produit(String titre, String description, String image, Double prix) {

        this.titre = titre;
        this.description = description;
        this.image = image;
        this.prix = prix;
    }
}
