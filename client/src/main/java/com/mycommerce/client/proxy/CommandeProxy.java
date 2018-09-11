package com.mycommerce.client.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mycommerce.client.bean.CommandeBean;

@FeignClient(name = "commande", url = "localhost:9002", decode404 = true)
public interface CommandeProxy {

	@PostMapping(value = "/commande")
	public ResponseEntity<CommandeBean> ajouterCommande(@RequestBody final CommandeBean commandeBean);

	@GetMapping(value = "/commande/{id}")
	public CommandeBean recupererUneCommande(@PathVariable(value = "id") final Long id);
}
