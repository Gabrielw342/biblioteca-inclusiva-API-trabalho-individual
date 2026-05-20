package com.biblioteca.bibliotecainclusa.dto.request;

public class PerfilAcessibilidadeRequestDTO {

    private String tipoNecessidade;

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