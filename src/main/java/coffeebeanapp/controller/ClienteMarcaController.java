package coffeebeanapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coffeebeanapp.model.ClienteMarca;
import coffeebeanapp.repository.ClienteMarcaRepository;

@RestController
@RequestMapping("/clienteMarcas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteMarcaController {
	@Autowired
	private ClienteMarcaRepository clienteMarcaRepository;// variavel que contem todos os atributos da model

	@GetMapping
	public ResponseEntity<List<ClienteMarca>> getAll() {
		return ResponseEntity.ok(clienteMarcaRepository.findAll()); // SELECT * FROM tb_categorias
	}
}
