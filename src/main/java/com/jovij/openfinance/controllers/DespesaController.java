package com.jovij.openfinance.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jovij.openfinance.models.Despesa;


@RestController
@RequestMapping("/despesa")
public class DespesaController {
    
    @GetMapping
    List<Despesa> getDespesas(){
    	Date dataDespesa = new Date();
    	try {
			dataDespesa = new SimpleDateFormat("DD/MM/YYYY").parse("15/02/2023");
    	}catch (ParseException e) {
    		e.printStackTrace();
		}
    	List<Despesa> listaDesp = new ArrayList<Despesa>();
        Despesa d1 = new Despesa(1L, "Aluguel", 800.5f, dataDespesa);
        listaDesp.add(d1);
        return listaDesp;
    }
}
