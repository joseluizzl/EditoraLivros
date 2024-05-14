package br.org.serratec.editora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.editora.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
