package br.dev.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.domain.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

}
