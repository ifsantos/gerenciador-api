package br.dev.domain.model.service;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.domain.model.Cliente;
import br.dev.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente salvar(@Valid Cliente cliente) {
		return repo.save(cliente);
	}

	public void excluir(Long clienteId) {
		repo.deleteById(clienteId);
	}
	
	public Cliente updateLocal(Cliente toBeUpdated, Cliente updates) {
		
		if (StringUtils.isNotBlank(updates.getFacebook())){
			toBeUpdated.setFacebook(updates.getFacebook());
		}
		if (StringUtils.isNotBlank(updates.getObservacoes())){
			toBeUpdated.setObservacoes(updates.getObservacoes());
		}
		if (StringUtils.isNotBlank(updates.getInstagram())){
			toBeUpdated.setInstagram(updates.getInstagram());
		}
		if (StringUtils.isNotBlank(updates.getNome())){
			toBeUpdated.setNome(updates.getNome());
		}
		if (StringUtils.isNotBlank(updates.getTelefone())){
			toBeUpdated.setTelefone(updates.getTelefone());
		}
		return toBeUpdated;
	}

}
