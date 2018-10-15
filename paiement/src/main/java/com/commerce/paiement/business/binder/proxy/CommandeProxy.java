package com.commerce.paiement.business.binder.proxy;

import com.commerce.paiement.business.binder.bean.CommandeBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Component
@FeignClient(name = "zuul")
@RibbonClient(name = "commande")
public interface CommandeProxy {

    @GetMapping(value = "/commande/commande/{id}")
    CommandeBean lookForOneCommande(@PathVariable(value = "id") final Long id);

    @PatchMapping(value = "/commande/commande")
    ResponseEntity<CommandeBean> updateCommande(@Valid @RequestBody final CommandeBean commandeBean);
}
