package com.biblioteca.bibliotecainclusa.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class CategoriaResponseDTO {

    @Schema(description = "Nome da categoria", example = "MEDIEVAL")
    private String nome;

    public CategoriaResponseDTO() {
    }

    public CategoriaResponseDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}