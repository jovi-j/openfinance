package com.jovij.openfinance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jovij.openfinance.models.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{
	
}
