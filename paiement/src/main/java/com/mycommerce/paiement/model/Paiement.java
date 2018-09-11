package com.mycommerce.paiement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Paiement {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private Long	idCommande;
	private Integer	montant;
	private Long	numeroCarte;

	public Paiement() {

	}

	public Paiement(final Long idCommande, final Integer montant, final Long numeroCarte) {

		this.idCommande = idCommande;
		this.montant = montant;
		this.numeroCarte = numeroCarte;
	}

	public Paiement(final Long id, final Long idCommande, final Integer montant, final Long numeroCarte) {

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
