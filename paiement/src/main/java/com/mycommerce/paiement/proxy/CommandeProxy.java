package com.mycommerce.paiement.proxy;

import java.util.Optional;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mycommerce.paiement.bean.CommandeBean;

@FeignClient(name = "commande")
@RibbonClient(name = "commande")
public interface CommandeProxy {

	@PutMapping(value = "/commande")
	void updateCommande(@RequestBody CommandeBean commandeBean);

	@GetMapping(value = "/commande/{id}")
	Optional<CommandeBean> recupererUneCommande(@PathVariable(value = "id") Long id);
}
