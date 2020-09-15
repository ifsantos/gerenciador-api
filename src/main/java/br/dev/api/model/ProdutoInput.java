package br.dev.api.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ProdutoInput {
	
	private Long id;
	
	@NotNull
	private String descricao;
	
	@NotNull
	@Positive
	private Double preco;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
