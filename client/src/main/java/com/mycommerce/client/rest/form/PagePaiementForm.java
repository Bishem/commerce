package com.mycommerce.client.rest.form;

public class PagePaiementForm {

	private Boolean etatPayement;

	public PagePaiementForm() {

	}

	public PagePaiementForm(final Boolean etatPayement) {

		this.setEtatPayement(etatPayement);
	}

	public Boolean getEtatPayement() {

		return this.etatPayement;
	}

	public void setEtatPayement(final Boolean etatPayement) {

		this.etatPayement = etatPayement;
	}
}
