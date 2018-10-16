package com.commerce.client.business.binder.proxy;

import com.commerce.client.business.binder.bean.CommandeBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Component
@RibbonClient(name = "commande")
@FeignClient(name = "zuul")
public interface CommandeProxy {

    @PostMapping(value = "/commande/commande")
    ResponseEntity<CommandeBean> postCommande(@Valid @RequestBody final CommandeBean commandeBean);

    @GetMapping(value = "/commande/commande/{id}")
    CommandeBean getCommande(@PathVariable(value = "id") final Long id);
}
