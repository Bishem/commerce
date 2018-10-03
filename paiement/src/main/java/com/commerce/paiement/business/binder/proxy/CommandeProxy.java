package com.commerce.paiement.business.binder.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.commerce.paiement.business.binder.bean.CommandeBean;

@RibbonClient(name = "commande")
@FeignClient(name = "commande")
public interface CommandeProxy {

	@GetMapping(value = "/commande/{idProduit}")
	CommandeBean recupererUneCommande(@PathVariable(value = "idProduit") final Long id);

	@PutMapping(value = "/commande")
	ResponseEntity<CommandeBean> updateCommande(@RequestBody final CommandeBean commandeBean);
}
