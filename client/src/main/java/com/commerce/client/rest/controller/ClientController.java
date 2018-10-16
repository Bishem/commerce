package com.commerce.client.rest.controller;

import com.commerce.client.business.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {
    
    private ClientService clientService;

    @Autowired
    public void setClientService(final ClientService clientService) {

        this.clientService = clientService;
    }

    @GetMapping("")
    public ModelAndView accueil() {
        
        final ModelAndView mav = new ModelAndView("accueil");
        mav.addObject("produits", this.clientService.listerProduits());
        
        return mav;
    }

    @GetMapping("/detailler/{id}")
    public ModelAndView produit(@PathVariable final Long id) {
        
        final ModelAndView mav = new ModelAndView("produit");
        mav.addObject("produit", this.clientService.recupererProduit(id));
        
        return mav;
    }

    @GetMapping("/commander/{idProduit}")
    public ModelAndView commande(@PathVariable final Long idProduit) {

        final ModelAndView mav = new ModelAndView("commande");
        mav.addObject("commande", this.clientService.creerCommande(idProduit));

        return mav;
    }

    @GetMapping("/payer/{idCommande}")
    public ModelAndView paiement(@PathVariable final Long idCommande) {

        final ModelAndView mav = new ModelAndView("paiement");
        mav.addObject("paiement", this.clientService.creerPaiement(idCommande));

        return mav;
    }

    @GetMapping("/suivre/{idCommande}")
    public ModelAndView expedition(@PathVariable final Long idCommande) {

        final ModelAndView mav = new ModelAndView("expedition");
        mav.addObject("expedition", this.clientService.recupererExpedition(idCommande));

        return mav;
    }
}
