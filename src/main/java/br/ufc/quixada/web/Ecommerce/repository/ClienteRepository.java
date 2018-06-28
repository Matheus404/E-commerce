package br.ufc.quixada.web.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.quixada.web.Ecommerce.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
