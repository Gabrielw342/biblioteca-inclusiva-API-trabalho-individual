package com.biblioteca.bibliotecainclusa.dto.request;

import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

public class CategoriaRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    @Schema(
        description = "Nome da categoria do livro",
        example = "COMEDIA"
    )
    private String nome;

    public CategoriaRequestDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}