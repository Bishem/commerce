package com.commerce.client.business.binder.proxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.commerce.client.business.binder.bean.ProduitBean;

@RibbonClient(name = "produit")
@FeignClient(name = "zuul")
public interface ProduitProxy {

	@GetMapping(value = "/produit/produit")
	List<ProduitBean> listeDesProduits();

	@GetMapping(value = "/produit/produit/{id}")
	ProduitBean recupererUnProduit(@PathVariable(value = "id") Long id);
}
