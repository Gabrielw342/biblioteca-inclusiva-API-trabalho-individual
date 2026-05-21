package com.biblioteca.bibliotecainclusa.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

public class PerfilAcessibilidadeRequestDTO {

    @NotBlank(message = "Tipo de necessidade é obrigatório")
    @Schema(
        description = "Tipo de necessidade de acessibilidade",
        example = "Baixa visão"
    )
    private String tipoNecessidade;

    @NotNull(message = "Usuário é obrigatório")
    @Schema(
        description = "ID do usuário vinculado ao perfil",
        example = "1"
    )
    private Long usuarioId;

    public PerfilAcessibilidadeRequestDTO() {
    }

    public String getTipoNecessidade() {
        return tipoNecessidade;
    }

    public void setTipoNecessidade(String tipoNecessidade) {
        this.tipoNecessidade = tipoNecessidade;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}