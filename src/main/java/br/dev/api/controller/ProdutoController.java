package br.dev.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.dev.api.model.ProdutoInput;
import br.dev.domain.model.Produto;
import br.dev.domain.model.service.ProdutoService;
import br.dev.domain.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ProdutoService service;
	
	@Autowired
	private ProdutoRepository repo;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Produto> listar(){
		return repo.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto criar(@Valid @RequestBody ProdutoInput produto) {
		
		return repo.save(mapper.map(produto, Produto.class));
	}
	
	@PutMapping("/{produtoId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Produto editar(@Valid @PathVariable Long produtoId, @RequestBody ProdutoInput produto) {
		Produto p = getProduto(produtoId);
		
		return repo.save(service.updateLocal(p, produto));
	}
	
	@DeleteMapping("/{produtoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long produtoId) {
		Produto p = getProduto(produtoId) ;
		repo.delete(p);
	}
	
	private Produto getProduto(Long produtoId) {
		return repo.findById(produtoId).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
	}

}
