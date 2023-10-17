package coffeebeanapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coffeebeanapp.model.Tipo;
import coffeebeanapp.repository.TipoRepository;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("v1/tipos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TipoController {
	@Autowired
	private TipoRepository tipoRepository;

	@GetMapping
	public ResponseEntity<List<Tipo>> getAll() {
		return ResponseEntity.ok(tipoRepository.findAll());
	}

	// tipo por id
	@GetMapping("/id")
	public ResponseEntity<Optional<Tipo>> obterIdTipo(@PathParam("id") Long id) {
		return ResponseEntity.ok(tipoRepository.findById(id));

	}

	// filtrar tipo por nome
	@GetMapping("/nome")
	public List<Tipo> obterNomeTipo(@PathParam("nome") String nome) {
		return tipoRepository.findTipoEntityByNomeContaining(nome);
	}

}
