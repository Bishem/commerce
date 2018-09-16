package com.mycommerce.client.business.binder.bean;

public class PaiementBean {

	private Long	id;
	private Long	numeroCarte;
	private Double	montant;

	private Long idCommande;

	public PaiementBean() {

	}

	public PaiementBean(final Long numeroCarte, final Double montant, final Long idCommande) {

		this.montant = montant;
		this.numeroCarte = numeroCarte;
		this.idCommande = idCommande;
	}

	public PaiementBean(final Long id, final Long numeroCarte, final Double montant, final Long idCommande) {

		this.id = id;
		this.numeroCarte = numeroCarte;
		this.montant = montant;
		this.idCommande = idCommande;
	}

	public Long getId() {

		return this.id;
	}

	public Double getMontant() {

		return this.montant;
	}

	public Long getNumeroCarte() {

		return this.numeroCarte;
	}

	public Long getIdCommande() {

		return this.idCommande;
	}

	public void setId(final Long id) {

		this.id = id;
	}

	public void setMontant(final Double montant) {

		this.montant = montant;
	}

	public void setNumeroCarte(final Long numeroCarte) {

		this.numeroCarte = numeroCarte;
	}

	public void setIdCommande(final Long idCommande) {

		this.idCommande = idCommande;
	}

	@Override
	public String toString() {

		return "PaiementBean{" + "id=" + this.id + ", numeroCarte=" + this.numeroCarte + ", montant=" + this.montant
				+ ", idCommande=" + this.idCommande + '}';
	}
}
