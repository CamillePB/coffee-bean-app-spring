package coffeebeanapp.controller;

import java.util.List;

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
@RequestMapping("/tipos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TipoController {
	@Autowired
	private TipoRepository tipoRepository;

	@GetMapping
	public ResponseEntity<List<Tipo>> getAll() {
		return ResponseEntity.ok(tipoRepository.findAll()); // SELECT * FROM tb_categorias
	}
	
	@GetMapping("/nome")
	public List<Tipo> retornoTipoPorNome(@PathParam("nome") String nome) {// padrao para requisições de url
		return tipoRepository.findTipoEntityByNomeContaining(nome);
	}
	
}
