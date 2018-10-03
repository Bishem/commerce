package com.commerce.commande.persistence.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Commande {

	@Id
	@GeneratedValue
	private Long	id;
	private Date	date;
	private Integer	quantite;
	private Boolean	estPayee;

	private Long idProduit;

	public Commande() {

	}

	public Commande(final Date date, final Integer quantite, final Boolean estPayee, final Long idProduit) {

		this.date = date;
		this.quantite = quantite;
		this.estPayee = estPayee;
		this.idProduit = idProduit;
	}

	public Commande(final Long id, final Date date, final Integer quantite, final Boolean estPayee,
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

	public Date getDate() {

		return this.date;
	}

	public Boolean getEstPayee() {

		return this.estPayee;
	}

	public Long getIdProduit() {

		return this.idProduit;
	}

	public Integer getQuantite() {

		return this.quantite;
	}

	public void setQuantite(final Integer quantite) {

		this.quantite = quantite;
	}

	public void setId(final Long id) {

		this.id = id;
	}

	public void setDate(final Date date) {

		this.date = date;
	}

	public void setEstPayee(final Boolean estPayee) {

		this.estPayee = estPayee;
	}

	public void setIdProduit(final Long idProduit) {

		this.idProduit = idProduit;
	}

	@Override
	public String toString() {

		return "Commande{" + "id=" + this.id + ", date=" + this.date + ", quantite=" + this.quantite + ", estPayee="
				+ this.estPayee + ", idProduit=" + this.idProduit + '}';
	}
}
