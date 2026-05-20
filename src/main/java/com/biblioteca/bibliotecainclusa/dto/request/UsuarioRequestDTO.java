package com.biblioteca.bibliotecainclusa.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

public class UsuarioRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    @Schema(description = "Nome do usuário", example = "Pimenta Doce")
    private String nome;

    @Email(message = "Email inválido")
    @NotBlank(message = "Email é obrigatório")
    @Schema(description = "Email do usuário", example = "docepimenta@email.com")
    private String email;

    @NotBlank(message = "CPF é obrigatório")
    @Schema(description = "CPF do usuário", example = "12345678900")
    private String cpf;

    public UsuarioRequestDTO() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}