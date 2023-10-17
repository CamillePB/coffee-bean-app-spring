package coffeebeanapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coffeebeanapp.model.Marca;
import coffeebeanapp.repository.MarcaRepository;

@RestController
@RequestMapping("v1/marcas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MarcaController {
	@Autowired
	private MarcaRepository marcaRepository;// variavel que contem todos os atributos da model

	@GetMapping
	public ResponseEntity<List<Marca>> getAll() {
		return ResponseEntity.ok(marcaRepository.findAll()); // SELECT * FROM tb_categorias
	}
}
