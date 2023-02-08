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
        return buildResponse(repo.save(despesa), HttpStatus.CREATED);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<Despesa>> findAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Despesa> pagedResult = repo.findAll(paging);
        
        if(pagedResult.hasContent()){
            return buildResponseList(pagedResult.getContent(), HttpStatus.OK);
        }else{
            return buildResponseList(null, HttpStatus.OK);
        }
    }

    public ResponseEntity<Despesa> deleteByTitulo(String titulo) {
        Despesa despesa = repo.findByTitulo(titulo);
        if(!despesa.equals(null)){
            repo.delete(despesa);
            return buildResponse(despesa, HttpStatus.OK);
        }

        return buildResponse(despesa, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Despesa> updateByTitulo(String titulo){
        Despesa despesa = repo.findByTitulo(titulo);
        if(!despesa.equals(null)){
            repo.save(despesa);
            return buildResponse(despesa, HttpStatus.OK);
        }
        return buildResponse(despesa, HttpStatus.NOT_FOUND);
    }


    private ResponseEntity<Despesa> buildResponse(Despesa despesa, HttpStatus httpStatus){
        return new ResponseEntity<Despesa>(despesa, httpStatus);
    }

    private ResponseEntity<List<Despesa>> buildResponseList(List<Despesa> list, HttpStatus httpStatus){
        return new ResponseEntity<List<Despesa>>(list, httpStatus);
    }
}
