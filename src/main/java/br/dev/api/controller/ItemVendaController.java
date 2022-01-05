package br.dev.api.controller;


import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.dev.domain.model.ItemVenda;
import br.dev.domain.repository.ItemVendaRepository;

@RestController
@RequestMapping("/itensvenda")
public class ItemVendaController {
	
	@Autowired 
	private ItemVendaRepository repo;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ItemVenda> listar(){
		
		return repo.findAll();
	}
	@GetMapping("/{idVenda}")
	@ResponseStatus(HttpStatus.OK)
	public List<ItemVenda> listarItensVenda(@PathVariable Long idVenda){
		ItemVenda item = new ItemVenda();
		item.setVendaId(idVenda);
		return repo.findAll(Example.of(item));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ItemVenda criar(@Valid @RequestBody ItemVenda v) {
		
		ItemVenda item = mapper.map(v, ItemVenda.class);

		return repo.save(item);
	}

}
