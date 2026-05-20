package com.biblioteca.bibliotecainclusa.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

public class LivroRequestDTO {

    @NotBlank(message = "Título é obrigatório")
    @Schema(description = "Título do livro", example = "Inocencio Coitadinho")
    private String titulo;

    @NotBlank(message = "Autor é obrigatório")
    @Schema(description = "Autor do livro", example = "Vinho Diesel")
    private String autor;

    @NotBlank(message = "Editora é obrigatória")
    @Schema(description = "Editora do livro", example = "Editora Sandfall")
    private String editora;

    @NotBlank(message = "ISBN é obrigatório")
    @Schema(description = "Código ISBN do livro", example = "9788535902775")
    private String isbn;

    @NotNull(message = "Ano de lançamento é obrigatório")
    @Schema(description = "Ano de lançamento do livro", example = "1899")
    private Integer anoLancamento;

    @NotNull(message = "Categoria é obrigatória")
    @Schema(description = "ID da categoria do livro", example = "1")
    private Long categoriaId;

    public LivroRequestDTO() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}