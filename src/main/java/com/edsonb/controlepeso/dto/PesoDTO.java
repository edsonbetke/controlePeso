package com.edsonb.controlepeso.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.edsonb.controlepeso.domain.Peso;

public class PesoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatório")
	private Double peso;

	private Double imc;

	public PesoDTO() {

	}

	public PesoDTO(Peso obj) {
		id = obj.getId();
		peso = obj.getPeso();
		imc = obj.getImc();
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

	public Double getImc() {
		return imc;
	}

	public void setImc(Double imc) {
		this.imc = imc;
	}

}
