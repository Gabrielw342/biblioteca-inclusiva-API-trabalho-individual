package com.biblioteca.bibliotecainclusa.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class PerfilAcessibilidadeResponseDTO {

    private String tipoNecessidade;

    private String usuario;

    public PerfilAcessibilidadeResponseDTO() {
    }
    
    public PerfilAcessibilidadeResponseDTO(String tipoNecessidade, String usuario) {
        this.tipoNecessidade = tipoNecessidade;
        this.usuario = usuario;
    }

    public String getTipoNecessidade() {
        return tipoNecessidade;
    }

    public void setTipoNecessidade(String tipoNecessidade) {
        this.tipoNecessidade = tipoNecessidade;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}