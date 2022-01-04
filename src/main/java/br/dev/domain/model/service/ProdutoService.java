package br.dev.domain.model.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import br.dev.api.model.ProdutoInput;
import br.dev.domain.model.Produto;

@Service
public class ProdutoService {

	public Produto updateLocal(Produto toBeUpdated, ProdutoInput updates) {
		
		if (StringUtils.isNotBlank(updates.getDescricao())){
			toBeUpdated.setDescricao(updates.getDescricao());
		}
		if (StringUtils.isNotBlank(updates.getObservacoes())){
			toBeUpdated.setObservacoes(updates.getObservacoes());
		}
		if (null != updates.getPreco()){
			toBeUpdated.setPreco(updates.getPreco());
		}

		return toBeUpdated;
	}
}
