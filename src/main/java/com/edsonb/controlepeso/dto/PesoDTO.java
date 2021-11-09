package com.edsonb.controlepeso.dto;

import java.io.Serializable;

import com.edsonb.controlepeso.domain.Peso;

public class PesoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Double peso;

	public PesoDTO() {

	}

	public PesoDTO(Peso obj) {
		id = obj.getId();
		peso = obj.getPeso();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

}
