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

    @GetMapping(value = "/expedition/{id}")
    public Expedition lookForOneExpedition(@PathVariable final Long id) {

        return this.expeditionService.getExpedition(id);
    }

    @PostMapping(value = "/expedition")
    public ResponseEntity<Expedition> addExpedition(@Valid @RequestBody final Expedition expedition) {

        return new ResponseEntity<>(this.expeditionService.postExpedition(expedition), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/expedition")
    public ResponseEntity<Expedition> updateExpedition(@Valid @RequestBody final Expedition expedition) {

        return new ResponseEntity<>(this.expeditionService.patchExpedition(expedition), HttpStatus.CREATED);
    }
}
