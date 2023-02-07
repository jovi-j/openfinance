package com.jovij.openfinance.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jovi
 * @param id
 * @param titulo
 * @param valor
 * @param dataDaDespesa
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Despesa implements Serializable {

	public static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private String titulo;
	private Float valor;
	@Temporal(TemporalType.DATE)
	private Date dataDaDespesa;


}
