package com.commerce.expedition.controller;

import com.commerce.expedition.business.service.ExpeditionService;
import com.commerce.expedition.persistence.model.Expedition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ExpeditionController {

    private ExpeditionService expeditionService;

    @Autowired
    public void setExpeditionService(final ExpeditionService expeditionService) {

        this.expeditionService = expeditionService;
    }

    @GetMapping(value = "/expedition/{idCommande}")
    public Expedition getExpedition(@PathVariable final Long idCommande) {

        return this.expeditionService.readExpedition(idCommande);
    }

    @PostMapping(value = "/expedition")
    public ResponseEntity<Expedition> postExpedition(@Valid @RequestBody final Expedition expedition) {

        return new ResponseEntity<>(this.expeditionService.createExpedition(expedition), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/expedition")
    public ResponseEntity<Expedition> patchExpedition(@Valid @RequestBody final Expedition expedition) {

        return new ResponseEntity<>(this.expeditionService.updateExpedition(expedition), HttpStatus.CREATED);
    }
}
