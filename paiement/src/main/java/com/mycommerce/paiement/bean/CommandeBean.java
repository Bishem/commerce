package com.mycommerce.paiement.bean;

import java.util.Date;

public class CommandeBean {

	private Long	id;
	private Date	date;
	private Integer	quantite;
	private Boolean	estPayee;

	private Long idProduit;

	public CommandeBean() {

	}

	public CommandeBean(final Date date, final Integer quantite, final Long idProduit) {

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

		return "CommandeBean{" +
				"id=" + id +
				", date=" + date +
				", quantite=" + quantite +
				", estPayee=" + estPayee +
				", idProduit=" + idProduit +
				'}';
	}
}
