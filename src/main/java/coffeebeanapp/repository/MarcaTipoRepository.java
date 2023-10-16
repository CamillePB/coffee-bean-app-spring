package coffeebeanapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import coffeebeanapp.model.MarcaTipo;

public interface MarcaTipoRepository  extends JpaRepository<MarcaTipo, Long>{
//	List<MarcaTipo>findMarcaTipoEntityByNomeContaining(String nome);//encontrar por nome
}
