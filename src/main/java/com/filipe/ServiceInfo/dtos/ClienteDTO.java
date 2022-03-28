package com.filipe.ServiceInfo.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.filipe.ServiceInfo.dominian.Cliente;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message = "Campo nome é obrigatório!")
	private String nome;
	@NotEmpty(message = "Campo endereço é obrigatório!")
	private String endereco;
	private String fone;
	
	public ClienteDTO() {
		super();
	}

	public ClienteDTO(Cliente obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.endereco = obj.getEndereco();
		this.fone = obj.getFone();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}
	
	
}
