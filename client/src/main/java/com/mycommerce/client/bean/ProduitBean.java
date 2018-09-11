package com.mycommerce.client.bean;

public class ProduitBean {

	private Long	id;
	private String	titre;
	private String	description;
	private String	image;
	private Double	prix;

	public ProduitBean() {

	}

	public ProduitBean(final Long id, final String titre, final String description, final String image,
			final Double prix) {

		this.id = id;
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

		return "ProduitBean{" + "id=" + this.id + ", titre='" + this.titre + '\'' + ", description='" + this.description
				+ '\'' + ", image='" + this.image + '\'' + ", prix=" + this.prix + '}';
	}
}
