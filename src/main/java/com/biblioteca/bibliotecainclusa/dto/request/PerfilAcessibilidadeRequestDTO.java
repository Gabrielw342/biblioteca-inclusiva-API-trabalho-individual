package com.biblioteca.bibliotecainclusa.dto.request;

import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

public class PerfilAcessibilidadeRequestDTO {

    @NotBlank(message = "Tipo de acessibilidade é obrigatório")
    @Schema(description = "Tipo de acessibilidade (ex: braile, áudio livro, leitor de tela, fonte grande)", example = "braile")
    private String tipoAcessibilidade;

    @Schema(description = "Descrição opcional da acessibilidade", example = "Versão do livro em braile para leitura tátil")
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