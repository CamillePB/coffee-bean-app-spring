package coffeebeanapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coffeebeanapp.model.Cliente;
import coffeebeanapp.model.Venda;
import coffeebeanapp.repository.VendaRepository;
import jakarta.persistence.TypedQuery;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("v1/vendas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VendaController {
	@Autowired
	private VendaRepository vendaRepository;

	@GetMapping
	public ResponseEntity<List<Venda>> getAll() {
		return ResponseEntity.ok(vendaRepository.findAll());
	}

	// Encontrar Venda por id
	@GetMapping("/id")
	public Optional<Venda> retornoClienteMarcaPorId(@PathParam("id") Long id) {
		return vendaRepository.findById(id);
	}

	// Encontrar nome de cliente por Id de Venda
	@GetMapping("/{id}/cliente/nome")
	public String obterNomeDoClientePorId(@PathVariable Long id) {// id de CLienteMarca mostrando o nome do cliente
		Optional<Venda> chamaCliente = vendaRepository.findById(id);

		if (chamaCliente.isPresent()) {
			Cliente cliente = chamaCliente.get().getCliente();
			return cliente.getNome();
		} else {
			return "cliente n encontrado";
		}
	}

	@GetMapping("/data/{data}")
	public ResponseEntity<List<Venda>> filtrarPorDataEspecifica(@PathVariable String data) {
		return ResponseEntity.ok(vendaRepository.findAllByDataContainingIgnoreCase(data));
	}

	@GetMapping("/datas/{dataMin}/{dataMax}")
	public ResponseEntity<List<Venda>> filtrarEntreDatas(
	        @PathParam("dataMin") String dataMin,
	        @PathParam("dataMax") String dataMax){ 
	return ResponseEntity.ok(vendaRepository.findByDataBetween(dataMin, dataMax));

	}
	
//	@GetMapping("/datasteste/{dataMin}/{dataMax}")
//	@Query("SELECT * FROM data WHERE data between data = :dataMin and data = :dataMax")
//    public String findByLoginAndSenha(@PathParam("dataMin") String dataMin, @PathParam("dataMax") String dataMax) {
//		return "Datas recebidas: Data mínima = " + dataMin + ", Data máxima = " + dataMax;
//	}
//	
//	
//
//	@GetMapping("/datas/{dataMin}/{dataMax}")
//	public String getDataRange(@PathParam("dataMin") String dataMin, @PathParam("dataMax") String dataMax) {
//		// Seu código para lidar com as datas aqui
//		return "Datas recebidas: Data mínima = " + dataMin + ", Data máxima = " + dataMax;
//	}

}
