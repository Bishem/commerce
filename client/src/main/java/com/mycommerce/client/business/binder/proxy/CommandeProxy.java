package com.mycommerce.client.business.binder.proxy;

import java.util.Optional;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mycommerce.client.business.binder.bean.CommandeBean;

@FeignClient(name = "zuul")
@RibbonClient(name = "commande")
public interface CommandeProxy {

	@PostMapping(value = "/commande/commande")
	public ResponseEntity<CommandeBean> ajouterCommande(@RequestBody final CommandeBean commandeBean);

	@GetMapping(value = "/commande/commande/{id}")
	public Optional<CommandeBean> recupererUneCommande(@PathVariable(value = "id") final Long id);
}