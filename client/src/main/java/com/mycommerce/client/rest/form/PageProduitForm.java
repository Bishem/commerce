package com.mycommerce.client.rest.form;

import java.util.Optional;

import com.mycommerce.client.business.binder.bean.ProduitBean;

public class PageProduitForm {

	ProduitBean produitBean;

	public PageProduitForm() {

	}

	public PageProduitForm(final Optional<ProduitBean> produitBean) {

		this.setProduitBean(produitBean.get());
	}

	public ProduitBean getProduitBean() {

		return this.produitBean;
	}

	public void setProduitBean(final ProduitBean produitBean) {

		this.produitBean = produitBean;
	}
}
