package com.commerce.client.business.binder.proxy;

import com.commerce.client.business.binder.bean.ProduitBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@RibbonClient(name = "produit")
@FeignClient(name = "zuul")
public interface ProduitProxy {

    @GetMapping(value = "/produit/produit")
    List<ProduitBean> getProduits();

    @GetMapping(value = "/produit/produit/{id}")
    ProduitBean getProduit(@PathVariable(value = "id") Long id);
}
