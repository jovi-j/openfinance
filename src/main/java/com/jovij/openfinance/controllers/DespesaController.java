package com.jovij.openfinance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jovij.openfinance.models.Despesa;
import com.jovij.openfinance.services.DespesaService;


@RestController
@RequestMapping("/despesa")
public class DespesaController {

    @Autowired
    private DespesaService service;
	
    @GetMapping
    ResponseEntity<List<Despesa>> getDespesas(){
        return service.findAll();
    }
    
    @PostMapping
    ResponseEntity<Despesa> createDespesa(@RequestBody Despesa despesa) {
    	return service.create(despesa);
    }
    
    
}
