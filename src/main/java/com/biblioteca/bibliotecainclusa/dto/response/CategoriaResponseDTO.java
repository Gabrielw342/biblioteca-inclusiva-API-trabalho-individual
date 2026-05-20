package com.biblioteca.bibliotecainclusa.dto.response;

public class CategoriaResponseDTO {

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