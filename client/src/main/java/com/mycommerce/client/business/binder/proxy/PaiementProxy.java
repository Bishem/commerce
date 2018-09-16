package com.mycommerce.client.business.binder.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mycommerce.client.business.binder.bean.PaiementBean;

@FeignClient(name = "zuul")
@RibbonClient(name = "paiment")
public interface PaiementProxy {

	@PostMapping(value = "/paiement")
	public ResponseEntity<PaiementBean> payerUneCommande(@RequestBody final PaiementBean paiementBean);
}
