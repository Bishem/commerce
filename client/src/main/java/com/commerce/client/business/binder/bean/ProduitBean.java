package com.commerce.client.business.binder.bean;

import lombok.Data;

@Data
public class ProduitBean {

    private Long id;
    private String titre;
    private String description;
    private String image;
    private Double prix;
}
