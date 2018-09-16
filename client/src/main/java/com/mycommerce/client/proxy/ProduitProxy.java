package com.mycommerce.client.proxy;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mycommerce.client.bean.ProduitBean;

@FeignClient(name = "zuul")
@RibbonClient(name = "produit")
public interface ProduitProxy {

	@GetMapping(value = "/produit")
	List<ProduitBean> listeDesProduits();

	@GetMapping(value = "/produit/{id}")
	Optional<ProduitBean> recupererUnProduit(@PathVariable(value = "id") Long id);
}
