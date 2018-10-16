package com.commerce.client.business.binder.proxy;

import com.commerce.client.business.binder.bean.ExpeditionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@RibbonClient(name = "expedition")
@FeignClient(name = "zuul")
public interface ExpeditionProxy {

    @GetMapping(value = "/expedition/expedition/{idCommande}")
    ExpeditionBean getExpedition(@PathVariable(value = "idCommande") final Long idCommande);
}
