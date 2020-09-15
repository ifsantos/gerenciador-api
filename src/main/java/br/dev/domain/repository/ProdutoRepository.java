package br.dev.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.domain.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
