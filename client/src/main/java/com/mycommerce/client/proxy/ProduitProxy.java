package com.mycommerce.client.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mycommerce.client.bean.ProduitBean;

@FeignClient(name = "produit", url = "localhost:9001")
public interface ProduitProxy {

	@GetMapping(value = "/produit")
	List<ProduitBean> listeDesProduits();

	@GetMapping(value = "/produit/{id}")
	ProduitBean recupererUnProduit(@PathVariable(value = "id") Long id);
}
