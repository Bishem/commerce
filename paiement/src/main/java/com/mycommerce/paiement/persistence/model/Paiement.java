package com.mycommerce.paiement.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paiement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long	numeroCarte;
	private Integer	montant;

	@Column(unique = true)
	private Long idCommande;

	public Paiement() {

	}

	public Paiement(final Long numeroCarte, final Integer montant, final Long idCommande) {

		this.montant = montant;
		this.numeroCarte = numeroCarte;
		this.idCommande = idCommande;
	}

	public Paiement(final Long id, final Long numeroCarte, final Integer montant, final Long idCommande) {

		this.id = id;
		this.numeroCarte = numeroCarte;
		this.montant = montant;
		this.idCommande = idCommande;
	}

	public Long getId() {

		return this.id;
	}

	public Integer getMontant() {

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

	public void setMontant(final Integer montant) {

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

		return "Paiement{" + "id=" + this.id + ", numeroCarte=" + this.numeroCarte + ", montant=" + this.montant
				+ ", idCommande=" + this.idCommande + '}';
	}
}
