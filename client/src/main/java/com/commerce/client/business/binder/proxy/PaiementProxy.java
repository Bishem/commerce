package com.commerce.client.business.binder.proxy;

import com.commerce.client.business.binder.bean.PaiementBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Component
@RibbonClient(name = "paiment")
@FeignClient(name = "zuul")
public interface PaiementProxy {

    @PostMapping(value = "/paiement/paiement")
    ResponseEntity<PaiementBean> postPaiement(@Valid @RequestBody final PaiementBean paiementBean);
}
