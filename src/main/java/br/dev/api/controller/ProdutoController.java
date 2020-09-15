package br.dev.api.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.dev.api.model.ProdutoInput;
import br.dev.domain.model.Produto;
import br.dev.domain.repository.ProdutoRepository;

@RestController("/produtos")
public class ProdutoController {
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ProdutoRepository repo;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto criar(@Valid @RequestBody ProdutoInput produto) {
		
		return repo.save(mapper.map(produto, Produto.class));
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Produto editar(@Valid @RequestBody ProdutoInput produto) {
		Produto p = repo.findById(produto.getId()).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
		p.setDescricao(produto.getDescricao());
		p.setPreco(produto.getPreco());
		return repo.save(p);
	}

}
