package br.org.serratec.editora.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.org.serratec.editora.dto.LivroDto;
import br.org.serratec.editora.model.Livro;
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
	
	public LivroDto salvarLivro(LivroDto novoLivro) {
        // Aqui aconteceriam outras validações de conteúdo
        Livro livroSalvo = livroRepository.save(novoLivro.toEntity());
        return livroSalvo.toDto();
    }
	
	public Optional<LivroDto> obterLivroPorId(Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		
		if (livro.isPresent()) {
			return Optional.of(livro.get().toDto());
		}
		
		return Optional.empty();
	}
	
	public Optional<LivroDto> atualizarLivro(Long id, LivroDto livroAlterado) {
        Livro livroEntity = livroAlterado.toEntity();

        if (livroRepository.existsById(id)) {
            livroEntity.setId(id);
            livroRepository.save(livroEntity);
            return Optional.of(livroEntity.toDto());
        }
        return Optional.empty();
    }
	
	public boolean excluirLivro(Long id) {
		if (livroRepository.existsById(id)) {
			 livroRepository.deleteById(id);
			 return true;
		}
		
		 return false;
	}
	
	public List<LivroDto> obterPorInicioTitulo(String inicioTitulo) {
		List<LivroDto> livros = new ArrayList<>();
		livroRepository.findByTituloStartingWithIgnoreCase(inicioTitulo).forEach(l -> {
			livros.add(l.toDto());
		});
		return livros;
	}
	
	public List<LivroDto> obterFinalAutor(String finalAutor) {
		List<LivroDto> livros = new ArrayList<>();
		livroRepository.findByAutorEndingWithIgnoreCase(finalAutor).forEach(l -> {
			livros.add(l.toDto());
		});
		return livros;
	}
	
	public List<LivroDto> obterPorAutorETitulo(String autor, String titulo) {
		List<LivroDto> livros = new ArrayList<>();
		livroRepository.findByAutorAndTituloIgnoreCase(autor, titulo).forEach(l -> {
			livros.add(l.toDto());
		});
		return livros;
	}
}
