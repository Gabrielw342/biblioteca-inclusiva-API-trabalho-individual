package com.biblioteca.bibliotecainclusa.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

public class UsuarioResponseDTO {

    @Schema(description = "ID do usuário", example = "1")
    private Long id;

    @Schema(description = "Nome do usuário", example = "João Silva")
    private String nome;

    @Schema(description = "Email do usuário", example = "joao@email.com")
    private String email;

    @Schema(
        description = "Perfis de acessibilidade do usuário",
        example = "[\"Baixa visão\", \"Dislexia\"]"
    )
    private List<String> perfis;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(Long id, String nome, String email, List<String> perfis) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.perfis = perfis;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getPerfis() {
        return perfis;
    }
}