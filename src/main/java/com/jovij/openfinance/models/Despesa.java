package com.jovij.openfinance.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * @author jovi
 * @param id
 * @param titulo
 * @param valor
 * @param dataDaDespesa
 */
@Entity
public class Despesa implements Serializable {

	public static final Long serialVersionUID = 1L;

	public Despesa() {
	}

	public Despesa(Long id, String titulo, Float valor, Date dataDaDespesa) {
		this.id = id;
		this.titulo = titulo;
		this.valor = valor;
		this.dataDaDespesa = dataDaDespesa;
	}

	@Id
	@GeneratedValue
	private Long id;

	@Basic
	private String titulo;

	@Basic
	private Float valor;

	@Basic
	@Temporal(TemporalType.DATE)
	private Date dataDaDespesa;

	@Override
	public int hashCode() {
		return Objects.hash(dataDaDespesa, id, titulo, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Despesa other = (Despesa) obj;
		return Objects.equals(dataDaDespesa, other.dataDaDespesa) && Objects.equals(id, other.id)
				&& Objects.equals(titulo, other.titulo) && Objects.equals(valor, other.valor);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Date getDataDaDespesa() {
		return dataDaDespesa;
	}

	public void setDataDaDespesa(Date dataDaDespesa) {
		this.dataDaDespesa = dataDaDespesa;
	}

}
