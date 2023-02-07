package com.jovij.openfinance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jovij.openfinance.models.Despesa;
import com.jovij.openfinance.repositories.DespesaRepository;

@Service
public class DespesaService {
   
    @Autowired
    private DespesaRepository repo;

    public ResponseEntity<Despesa> create(Despesa despesa) {
        return new ResponseEntity<Despesa>(repo.save(despesa), HttpStatus.CREATED);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<Despesa>> findAll() {
        return new ResponseEntity<List<Despesa>>(repo.findAll(), HttpStatus.OK);
    }


}
