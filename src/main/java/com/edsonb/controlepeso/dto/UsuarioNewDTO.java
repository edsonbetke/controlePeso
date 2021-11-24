package com.edsonb.controlepeso.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class UsuarioNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String email;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String senha;

	private Double altura;
	private Integer idade;

	public UsuarioNewDTO() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

}
