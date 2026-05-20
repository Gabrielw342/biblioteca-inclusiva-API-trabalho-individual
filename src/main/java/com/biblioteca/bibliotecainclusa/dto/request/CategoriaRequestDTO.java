package com.biblioteca.bibliotecainclusa.dto.request;

import jakarta.validation.constraints.NotBlank;

public class CategoriaRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
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