package br.dev.api.model;

import java.util.List;

import javax.validation.constraints.NotNull;

public class VendaInput {
	@NotNull
	private ClienteInput cliente;
	@NotNull
	private List<ItemVendaInput> itens;
	public ClienteInput getCliente() {
		return cliente;
	}
	public void setCliente(ClienteInput cliente) {
		this.cliente = cliente;
	}
	public List<ItemVendaInput> getItens() {
		return itens;
	}
	public void setItens(List<ItemVendaInput> itens) {
		this.itens = itens;
	}
	
}
