package com.biblioteca.bibliotecainclusa.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class PerfilAcessibilidadeResponseDTO {

    @Schema(description = "ID do perfil de acessibilidade", example = "1")
    private Long id;

    @Schema(description = "Tipo de necessidade de acessibilidade", example = "Baixa visão")
    private String tipoNecessidade;

    public PerfilAcessibilidadeResponseDTO() {
    }

    public PerfilAcessibilidadeResponseDTO(Long id, String tipoNecessidade) {
        this.id = id;
        this.tipoNecessidade = tipoNecessidade;
    }

    public Long getId() {
        return id;
    }

    public String getTipoNecessidade() {
        return tipoNecessidade;
    }
}