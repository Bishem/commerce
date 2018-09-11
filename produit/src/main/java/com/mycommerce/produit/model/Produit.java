package com.mycommerce.produit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produit {

	@Id
	@GeneratedValue
	private Long	id;
	private String	titre;
	private String	description;
	private String	image;
	private Double	prix;

	public Produit() {

	}

	public Produit(final Long id, final String titre, final String description, final String image, final Double prix) {

		this.id = id;
		this.titre = titre;
		this.description = description;
		this.image = image;
		this.prix = prix;
	}

	public Long getId() {

		return this.id;
	}

	public void setId(final Long id) {

		this.id = id;
	}

	public String getTitre() {

		return this.titre;
	}

	public void setTitre(final String titre) {

		this.titre = titre;
	}

	public String getDescription() {

		return this.description;
	}

	public void setDescription(final String description) {

		this.description = description;
	}

	public String getImage() {

		return this.image;
	}

	public void setImage(final String image) {

		this.image = image;
	}

	public Double getPrix() {

		return this.prix;
	}

	public void setPrix(final Double prix) {

		this.prix = prix;
	}

	@Override
	public String toString() {

		return "Produit{" + "id=" + this.id + ", titre='" + this.titre + '\'' + ", description='" + this.description
				+ '\'' + ", image='" + this.image + '\'' + ", prix=" + this.prix + '}';
	}
}
