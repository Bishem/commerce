package com.commerce.client.business.service;

import com.commerce.client.business.binder.bean.CommandeBean;
import com.commerce.client.business.binder.bean.ExpeditionBean;
import com.commerce.client.business.binder.bean.PaiementBean;
import com.commerce.client.business.binder.bean.ProduitBean;
import com.commerce.client.business.binder.proxy.CommandeProxy;
import com.commerce.client.business.binder.proxy.ExpeditionProxy;
import com.commerce.client.business.binder.proxy.PaiementProxy;
import com.commerce.client.business.binder.proxy.ProduitProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ClientServiceImpl implements ClientService {

    private final Random random = new Random();

    private ProduitProxy produitProxy;
    private CommandeProxy commandeProxy;
    private PaiementProxy paiementProxy;
    private ExpeditionProxy expeditionProxy;

    @Autowired
    public void setProduitProxy(final ProduitProxy produitProxy) {

        this.produitProxy = produitProxy;
    }

    @Autowired
    public void setCommandeProxy(final CommandeProxy commandeProxy) {

        this.commandeProxy = commandeProxy;
    }

    @Autowired
    public void setPaiementProxy(final PaiementProxy paiementProxy) {

        this.paiementProxy = paiementProxy;
    }

    @Autowired
    public void setExpeditionProxy(final ExpeditionProxy expeditionProxy) {

        this.expeditionProxy = expeditionProxy;
    }

    @Override
    public List<ProduitBean> listerProduits() {

        return this.produitProxy.getProduits();
    }

    @Override
    public ProduitBean recupererProduit(final Long id) {

        return this.produitProxy.getProduit(id);
    }

    @Override
    public CommandeBean creerCommande(final Long idProduit) {


        return this.commandeProxy.postCommande(
                new CommandeBean(
                        new Date(),
                        this.getQuantity(),
                        Boolean.FALSE,
                        idProduit)).getBody();
    }

    @Override
    public PaiementBean creerPaiement(final Long idCommande) {

        return this.paiementProxy.postPaiement(
                new PaiementBean(
                        this.getCardNumber().longValue(),
                        this.getAmount(idCommande),
                        idCommande)).getBody();
    }

    @Override
    public ExpeditionBean recupererExpedition(Long idCommande) {

        return this.expeditionProxy.getExpedition(idCommande);
    }

    private Double getAmount(Long idCommande) {

        final CommandeBean commandeBean = this.commandeProxy.getCommande(idCommande);
        final ProduitBean produitBean = this.produitProxy.getProduit(commandeBean.getIdProduit());

        return produitBean.getPrix() * commandeBean.getQuantite();
    }

    private Integer getCardNumber() {

        return this.random.nextInt(1000000000) + 1000000000;
    }

    private Integer getQuantity() {

        return this.random.nextInt(10) + 10;
    }
}
