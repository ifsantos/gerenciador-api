package br.dev.api.controller;


import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.dev.domain.model.Venda;
import br.dev.domain.repository.VendaRepository;

@RestController
@RequestMapping("/vendas")
public class VendaController {
	@Autowired 
	private VendaRepository repo;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Venda criar(@Valid @RequestBody Venda v) {
		
		Venda venda = mapper.map(v, Venda.class);

		return repo.save(venda);
	}

}
