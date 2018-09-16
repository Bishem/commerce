package com.mycommerce.commande.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long	id;
	private Date	date;
	private Integer	quantite;
	private Boolean	estPayee;

	private Long idProduit;

	public Commande() {

	}

	public Commande(final Date date, final Integer quantite, final Long idProduit) {

		this.date = date;
		this.quantite = quantite;
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

		return "Commande{" +
				"id=" + id +
				", date=" + date +
				", quantite=" + quantite +
				", estPayee=" + estPayee +
				", idProduit=" + idProduit +
				'}';
	}
}
