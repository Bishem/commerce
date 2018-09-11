package com.client.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.client.bean.ProduitBean;

@FeignClient(name = "produit", url = "localhost:9001", decode404 = true)
public interface ProduitProxy {

	@GetMapping(value = "/produit")
	List<ProduitBean> listeDesProduits();

	@GetMapping(value = "/produit/{id}")
	ProduitBean recupererUnProduit(@PathVariable(value = "id") Long id);
}
