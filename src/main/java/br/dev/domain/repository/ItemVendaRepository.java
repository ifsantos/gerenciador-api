package br.dev.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.domain.model.ItemVenda;

public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {

}
