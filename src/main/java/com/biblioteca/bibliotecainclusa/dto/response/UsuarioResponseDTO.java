package com.biblioteca.bibliotecainclusa.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class UsuarioResponseDTO {

    @Schema(description = "Nome do usuário", example = "João Silva")
    private String nome;

    @Schema(description = "Email do usuário", example = "joao@email.com")
    private String email;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}