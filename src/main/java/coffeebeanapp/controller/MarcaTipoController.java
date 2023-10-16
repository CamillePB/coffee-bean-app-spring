package coffeebeanapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coffeebeanapp.model.MarcaTipo;
import coffeebeanapp.repository.MarcaTipoRepository;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/marcaTipo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MarcaTipoController {
	@Autowired
	private MarcaTipoRepository marcaTipoRepository;// variavel que contem todos os atributos da model

	@GetMapping
	public ResponseEntity<List<MarcaTipo>> getAll() {
		return ResponseEntity.ok(marcaTipoRepository.findAll()); // SELECT * FROM tb_categorias
	}
	
//	@GetMapping("/nome")
//	public List<MarcaTipo> retornoMarcaTipoPorNome(@PathParam("nome") String nome) {// padrao para requisições de url
//		return marcaTipoRepository.findMarcaTipoEntityByNomeContaining(nome);
//	}
}
