package com.commerce.client.business.binder.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.commerce.client.business.binder.bean.CommandeBean;

@RibbonClient(name = "commande")
@FeignClient(name = "zuul")
public interface CommandeProxy {

	@PostMapping(value = "/commande/commande")
	ResponseEntity<CommandeBean> ajouterCommande(@RequestBody final CommandeBean commandeBean);

	@GetMapping(value = "/commande/commande/{idProduit}")
	CommandeBean recupererUneCommande(@PathVariable(value = "idProduit") final Long id);
}
