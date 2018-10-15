package com.commerce.commande.business.binder.proxy;

import com.commerce.commande.business.binder.bean.ExpeditionBean;
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
@RibbonClient(name = "expedition")
public interface ExpeditionProxy {

    @GetMapping(value = "/expedition/expedition/{id}")
    ExpeditionBean lookForOneExpedition(@PathVariable(value = "id") final Long id);

    @PatchMapping(value = "/expedition/expedition")
    ResponseEntity<ExpeditionBean> updateExpedition(@Valid @RequestBody final ExpeditionBean expeditionBean);
}
