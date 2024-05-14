package br.org.serratec.editora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.editora.dto.LivroDto;
import br.org.serratec.editora.service.LivroService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@GetMapping
	public ResponseEntity<List<LivroDto>> obterTodos() {
		return ResponseEntity.ok(livroService.obterTodos());
	}
	
	
	
}
