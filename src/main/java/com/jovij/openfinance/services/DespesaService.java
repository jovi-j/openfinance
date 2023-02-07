package com.jovij.openfinance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public ResponseEntity<List<Despesa>> findAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Despesa> pagedResult = repo.findAll(paging);
        
        if(pagedResult.hasContent()){
            return new ResponseEntity<List<Despesa>>(pagedResult.getContent(), HttpStatus.OK);
        }else{
            return new ResponseEntity<List<Despesa>>(HttpStatus.OK);
        }
    }


}
