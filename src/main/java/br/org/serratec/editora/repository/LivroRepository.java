package br.org.serratec.editora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.editora.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
	List<Livro> findByTituloStartingWithIgnoreCase(String inicioTitulo);
	List<Livro> findByAutorEndingWithIgnoreCase(String finalAutor);
	List<Livro> findByAutorAndTituloIgnoreCase(String autor, String titulo);

}
