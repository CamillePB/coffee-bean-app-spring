package coffeebeanapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import coffeebeanapp.model.Cliente;
import coffeebeanapp.model.Tipo;

public interface TipoRepository  extends JpaRepository<Tipo, Long>{
	List<Tipo>findTipoEntityByNomeContaining(String nome);//encontrar por nome
}
