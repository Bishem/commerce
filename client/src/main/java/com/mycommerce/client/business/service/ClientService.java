package com.mycommerce.client.business.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.mycommerce.client.business.binder.bean.ProduitBean;
import com.mycommerce.client.business.binder.proxy.CommandeProxy;
import com.mycommerce.client.business.binder.proxy.PaiementProxy;
import com.mycommerce.client.business.binder.proxy.ProduitProxy;
import com.mycommerce.client.rest.form.PageAccueilForm;
import com.mycommerce.client.rest.form.PageProduitForm;

@Service
public class ClientService {

	private final Random random;

	@Autowired
	private ProduitProxy produitProxy;

	@Autowired
	private CommandeProxy commandeProxy;

	@Autowired
	private PaiementProxy paiementProxy;

	public ClientService() {

		this.random = new Random();
	}

	public PageAccueilForm getAllProduits() {

		final PageAccueilForm pageAccueilForm = new PageAccueilForm();

		pageAccueilForm.setProduitBeans(this.produitProxy.listeDesProduits());

		return pageAccueilForm;
	}

	public ModelAndView getProduitById(final Long id) {

		final PageProduitForm pageProduitForm = new ;

		final Optional<ProduitBean> produitBean = this.produitProxy.recupererUnProduit(id);

		if (produitBean.isPresent()) {
			modelAndView.addObject("produit", produitBean.get());
		}

		return pageProduitForm;
	}

	private Integer quantiteAleatoire() {

		return this.random.nextInt(10) + 10;
	}

	private Long numeroCarteAleatoire() {

		return (long) (this.random.nextInt(1000000000) + 1000000000);
	}

}
