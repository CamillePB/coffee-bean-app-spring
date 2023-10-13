package coffeebeanapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coffeebeanapp.model.Marca;

public interface MarcaRepository  extends JpaRepository<Marca, Long>{

}
