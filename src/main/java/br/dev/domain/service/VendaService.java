package br.dev.domain.service;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.dev.domain.model.Cliente;
import br.dev.domain.model.ItemVenda;
import br.dev.domain.model.Venda;
import br.dev.domain.repository.ClienteRepository;
import br.dev.domain.repository.ProdutoRepository;
import br.dev.domain.repository.VendaRepository;

public class VendaService {
	@Autowired
	private VendaRepository repo;
	@Autowired
	private ClienteRepository cliRepo;
	@Autowired
	private ProdutoRepository prodRepo;
	
	public Venda criar(Venda v) {
		Cliente cliente = validarCliente(v.getCliente());
		v.setCliente(cliente);
		v.setItens(validarItens(v.getItens()));
		v.setData(OffsetDateTime.now());
		return repo.save(v);
	}

	private Cliente validarCliente(Cliente c) {
		return cliRepo.findById(c.getId())
				.orElseThrow(() -> new RuntimeException("Cliente inexistente"));
	}

	private List<ItemVenda> validarItens(List<ItemVenda> itens) {
		/*
		 * Code Snippet about collectors. EX:
		 * 	v.getItens() 
		 * 		.stream()
		 * 		.map(prodRepo.findById(iv.getId()).get()) 
		 * 		.collect(Collectors.toList())
		 */
		
		itens.forEach(i -> prodRepo.findById(i.getId())
				.orElseThrow(() -> new RuntimeException("Produto inexistente: "+i.getId())));
		return itens;
	}

}
