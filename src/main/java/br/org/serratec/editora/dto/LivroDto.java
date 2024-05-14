package br.org.serratec.editora.dto;

import br.org.serratec.editora.model.Livro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record LivroDto(
		 Long id,
		 @NotBlank
		 String titulo,
		 @NotBlank
		 String autor,
		 @Pattern(regexp="^(?:978|979)[0-9]{10}$")
		 String isbn) {

	public Livro toEntity() {
		return new Livro(
				this.id, this.titulo, this.autor, this.isbn
				);
				
	}
}
