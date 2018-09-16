package com.mycommerce.produit.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long	id;
	private String	titre;
	private String	description;
	private String	image;
	private Double	prix;

	public Produit() {

	}

	public Produit(final String titre, final String description, final String image, final Double prix) {

		this.titre = titre;
		this.description = description;
		this.image = image;
		this.prix = prix;
	}

	public Long getId() {

		return this.id;
	}

	public String getTitre() {

		return this.titre;
	}

	public String getDescription() {

		return this.description;
	}

	public String getImage() {

		return this.image;
	}

	public Double getPrix() {

		return this.prix;
	}

	public void setId(final Long id) {

		this.id = id;
	}

	public void setTitre(final String titre) {

		this.titre = titre;
	}

	public void setDescription(final String description) {

		this.description = description;
	}

	public void setImage(final String image) {

		this.image = image;
	}

	public void setPrix(final Double prix) {

		this.prix = prix;
	}

	@Override
	public String toString() {

		return "Produit{" +
				"id=" + id +
				", titre='" + titre + '\'' +
				", description='" + description + '\'' +
				", image='" + image + '\'' +
				", prix=" + prix +
				'}';
	}
}
