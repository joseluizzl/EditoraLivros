package br.org.serratec.editora.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.editora.dto.LivroDto;
import br.org.serratec.editora.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	public List<LivroDto> obterTodos() {
		List<LivroDto> livros = new ArrayList<>();
		livroRepository.findAll().forEach(l -> {
			livros.add(l.toDto());
		});
		return livros;
	}
}
