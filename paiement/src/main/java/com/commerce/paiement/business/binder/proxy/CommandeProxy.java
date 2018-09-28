package com.commerce.paiement.business.binder.proxy;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.commerce.paiement.business.binder.bean.CommandeBean;

//@RibbonClient(name = "commande")
@FeignClient(name = "commande", url = "localhost:9002")
public interface CommandeProxy {

//	@PutMapping(value = "/commande/commande")
	@PutMapping(value = "/commande")
	ResponseEntity<CommandeBean> updateCommande(@RequestBody final CommandeBean commandeBean);

//	@GetMapping(value = "/commande/commande/{id}")
	@GetMapping(value = "/commande/{id}")
	Optional<CommandeBean> recupererUneCommande(@PathVariable(value = "id") final Long id);
}
