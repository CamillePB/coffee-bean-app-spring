package coffeebeanapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coffeebeanapp.model.Cliente;

public interface MarcaRepository  extends JpaRepository<Cliente, Long>{

}
