package br.dev.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
