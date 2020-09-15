package br.dev.api.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ItemVendaInput {
	@NotNull
	private ProdutoInput produto;
	@NotNull
	@Positive
	private Long quantidade;
	
	
	public ProdutoInput getProduto() {
		return produto;
	}
	public void setProduto(ProdutoInput produto) {
		this.produto = produto;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	
}
