package br.org.serratec.editora.dto;

import br.org.serratec.editora.model.Livro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record LivroDto(
		 Long id,
		 @NotBlank(message="O título não pode ser vazio!")
		 String titulo,
		 @NotBlank(message="O campo deve conter um ou mais autores!")
		 String autor,
		 @Pattern(regexp="^(?:978|979)[0-9]{10}$", message="A estrutura do ISBN é composta de 13 números que indicam o título, o autor, o país, a editora e a edição de uma obra.!")
		 String isbn) {

	public Livro toEntity() {
		return new Livro(
				this.id, this.titulo, this.autor, this.isbn
				);
				
	}
}
