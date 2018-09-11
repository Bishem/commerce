package com.client.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.client.bean.PaiementBean;

@FeignClient(name = "paiement", url = "localhost:9003", decode404 = true)
public interface PaiementProxy {

	@PostMapping(value = "/paiement")
	public ResponseEntity<PaiementBean> payerUneCommande(@RequestBody final PaiementBean paiementBean);
}
