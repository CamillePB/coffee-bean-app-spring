package coffeebeanapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import coffeebeanapp.model.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Long>{
	Optional<Cliente>findClienteEntityByNomeContaining(String nome);
}
