package com.mycommerce.paiement.business.binder.proxy;

import java.util.Optional;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mycommerce.paiement.business.binder.bean.CommandeBean;

@FeignClient(name = "zuul")
@RibbonClient(name = "commande")
public interface CommandeProxy {

	@PutMapping(value = "/commande/commande")
	ResponseEntity<CommandeBean> updateCommande(@RequestBody CommandeBean commandeBean);

	@GetMapping(value = "/commande/commande/{id}")
	Optional<CommandeBean> recupererUneCommande(@PathVariable(value = "id") Long id);
}
