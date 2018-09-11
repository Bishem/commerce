package com.mycommerce.commande.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Commande {

	@Id
	@GeneratedValue
	private Long	id;
	private Long	idProduit;
	private Date	dateCommande;
	private Integer	quantite;
	private Boolean	commandePayee;

	public Commande() {

	}

	public Commande(final Long idProduit, final Date dateCommande, final Integer quantite,
			final Boolean commandePayee) {

		this.idProduit = idProduit;
		this.dateCommande = dateCommande;
		this.quantite = quantite;
		this.commandePayee = commandePayee;
	}

	public Commande(final Long id, final Long idProduit, final Date dateCommande, final Integer quantite,
			final Boolean commandePayee) {

		this.id = id;
		this.idProduit = idProduit;
		this.dateCommande = dateCommande;
		this.quantite = quantite;
		this.commandePayee = commandePayee;
	}

	public Long getId() {

		return this.id;
	}

	public void setId(final Long id) {

		this.id = id;
	}

	public Long getIdProduit() {

		return this.idProduit;
	}

	public void setIdProduit(final Long idProduit) {

		this.idProduit = idProduit;
	}

	public Date getDateCommande() {

		return this.dateCommande;
	}

	public void setDateCommande(final Date dateCommande) {

		this.dateCommande = dateCommande;
	}

	public Integer getQuantite() {

		return this.quantite;
	}

	public void setQuantite(final Integer quantite) {

		this.quantite = quantite;
	}

	public Boolean getCommandePayee() {

		return this.commandePayee;
	}

	public void setCommandePayee(final Boolean commandePayee) {

		this.commandePayee = commandePayee;
	}

	@Override
	public String toString() {

		return "commande{" + "id=" + this.id + ", idProduit=" + this.idProduit + ", dateCommande=" + this.dateCommande
				+ ", quantite=" + this.quantite + ", commandePayee=" + this.commandePayee + '}';
	}
}
