package com.mycommerce.client.rest.form;

import java.util.List;

import com.mycommerce.client.business.binder.bean.ProduitBean;

public class PageAccueilForm {

	private List<ProduitBean> produitBeans;

	public List<ProduitBean> getProduitBeans() {

		return this.produitBeans;
	}

	public void setProduitBeans(final List<ProduitBean> produitBeans) {

		this.produitBeans = produitBeans;
	}

}
