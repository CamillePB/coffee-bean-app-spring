package coffeebeanapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coffeebeanapp.model.Cliente;
import coffeebeanapp.repository.ClienteRepository;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("v1/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public ResponseEntity<List<Cliente>> getAll() {
		return ResponseEntity.ok(clienteRepository.findAll());
	}

	// cliente por id
	@GetMapping("/id")
	public ResponseEntity<Optional<Cliente>> obterIdCliente(@PathParam("id") Long id) {
		return ResponseEntity.ok(clienteRepository.findById(id));

	}

	// cliente por nome
	@GetMapping("/nome")
	public ResponseEntity<Optional<Cliente>> obterNomeCliente(@PathParam("nome") String nome) {
		return ResponseEntity.ok(clienteRepository.findClienteByNomeContaining(nome));

	}
}
