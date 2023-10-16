package coffeebeanapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coffeebeanapp.model.Cliente;
import coffeebeanapp.model.ClienteMarca;
import coffeebeanapp.repository.ClienteMarcaRepository;
import coffeebeanapp.repository.ClienteRepository;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/clienteMarcas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteMarcaController {
	@Autowired
	private ClienteMarcaRepository clienteMarcaRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public ResponseEntity<List<ClienteMarca>> getAll() {
		return ResponseEntity.ok(clienteMarcaRepository.findAll());
	}
	
	//Encontrar Cliente Marca por id
	@GetMapping("/id")
	public Optional<ClienteMarca> retornoClienteMarcaPorId(@PathParam("id") Long id) {
		return clienteMarcaRepository.findById(id);
	}
	
	//Encontrar nome de cliente por Id de Cliente Marca
	 @GetMapping("/{id}/cliente/nome")
	    public String obterNomeDoClientePorId(@PathVariable Long id) {//id de CLienteMarca mostrando o nome do cliente
	        Optional<ClienteMarca> chamaCliente = clienteMarcaRepository.findById(id);
	      
	        if (chamaCliente.isPresent()) {
	            Cliente cliente = chamaCliente.get().getCliente();
	            return cliente.getNome();
	        } else {
	            return "cliente n encontrado";
	        }
	    }
	 
	 // cliente por nome
	 @GetMapping("/cliente/nome")
	    public ResponseEntity<Optional<Cliente>> obterNomeCliente(@PathParam("nome") String nome) {
		 return ResponseEntity.ok(clienteRepository.findClienteEntityByNomeContaining(nome));
	        
//	        if (clienteOptional.isPresent()) {
//	            return ResponseEntity.ok(clienteOptional);
//	        } else {
//	            return ResponseEntity.notFound().build();
//	        }
	    }
	 

}
