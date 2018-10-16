package com.commerce.paiement.business.binder.proxy;

import com.commerce.paiement.business.binder.bean.ExpeditionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Component
@FeignClient(name = "zuul")
@RibbonClient(name = "expedition")
public interface ExpeditionProxy {

    @PostMapping(value = "/expedition/expedition")
    ResponseEntity<ExpeditionBean> postExpedition(@Valid @RequestBody final ExpeditionBean expeditionBean);
}
