package com.commerce.commande.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
public class Commande {

    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private Integer quantite;
    private Boolean estPayee;

    private Long idProduit;
}
