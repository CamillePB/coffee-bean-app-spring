package coffeebeanapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import coffeebeanapp.model.Venda;

public interface VendaRepository  extends JpaRepository<Venda, Long>{
	List<Venda> findVendaEntitiesByClienteIdContaining(Long clienteId);
	List<Venda> findAllByDataContainingIgnoreCase(@Param("data")String data); 
	public List<Venda>  findByDataBetween(String dataMin, String dataMax);
}
