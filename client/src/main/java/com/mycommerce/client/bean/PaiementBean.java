package com.mycommerce.client.bean;

public class PaiementBean {

	private Long	id;
	private Long	idCommande;
	private Integer	montant;
	private Long	numeroCarte;

	public PaiementBean() {

	}

	public PaiementBean(final Long id, final Long idCommande, final Integer montant, final Long numeroCarte) {

		this.id = id;
		this.idCommande = idCommande;
		this.montant = montant;
		this.numeroCarte = numeroCarte;
	}

	public Long getId() {

		return this.id;
	}

	public void setId(final Long id) {

		this.id = id;
	}

	public Long getIdCommande() {

		return this.idCommande;
	}

	public void setIdCommande(final Long idCommande) {

		this.idCommande = idCommande;
	}

	public Integer getMontant() {

		return this.montant;
	}

	public void setMontant(final Integer montant) {

		this.montant = montant;
	}

	public Long getNumeroCarte() {

		return this.numeroCarte;
	}

	public void setNumeroCarte(final Long numeroCarte) {

		this.numeroCarte = numeroCarte;
	}

	@Override
	public String toString() {

		return "Paiement{" + "id=" + this.id + ", idCommande=" + this.idCommande + ", montant=" + this.montant
				+ ", numeroCarte=" + this.numeroCarte + '}';
	}
}
