package br.dev.domain.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import br.dev.domain.model.Cliente;
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
		Cliente cliente = cliRepo.findById(v.getCliente().getId())
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
		v.setCliente(cliente);
		v.setItens(v.getItens()
				.stream()
				.map(iv -> prodRepo.findById(iv.getId()).get())
				.collect(Collectors.toList()));
		v.setData(OffsetDateTime.now());
		return repo.save(v);
	}

}
