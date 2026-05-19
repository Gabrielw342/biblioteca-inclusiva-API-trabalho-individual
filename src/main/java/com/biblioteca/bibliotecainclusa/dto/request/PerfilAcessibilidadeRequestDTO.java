package com.biblioteca.bibliotecainclusa.dto.request;

import jakarta.validation.constraints.NotBlank;

public class PerfilAcessibilidadeRequestDTO {

    @NotBlank(message = "Tipo de acessibilidade é obrigatório")
    private String tipoAcessibilidade;

    private String descricao;

    public PerfilAcessibilidadeRequestDTO() {
    }

    public String getTipoAcessibilidade() {
        return tipoAcessibilidade;
    }

    public void setTipoAcessibilidade(String tipoAcessibilidade) {
        this.tipoAcessibilidade = tipoAcessibilidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}