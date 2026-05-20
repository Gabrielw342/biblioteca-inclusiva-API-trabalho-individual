package com.biblioteca.bibliotecainclusa.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class LivroResponseDTO {

    @Schema(description = "Título do livro", example = "Dom Casmurro")
    private String titulo;

    @Schema(description = "Autor do livro", example = "Machado de Assis")
    private String autor;

    @Schema(description = "Editora do livro", example = "Editora Globo")
    private String editora;

    @Schema(description = "ISBN do livro", example = "9788535902775")
    private String isbn;

    @Schema(description = "Ano de lançamento do livro", example = "1899")
    private Integer anoLancamento;

    @Schema(description = "Categoria do livro", example = "Ficção")
    private String categoria;

    public LivroResponseDTO() {
    }

    public LivroResponseDTO(String titulo, String autor, String editora,
                            String isbn, Integer anoLancamento, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.isbn = isbn;
        this.anoLancamento = anoLancamento;
        this.categoria = categoria;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}