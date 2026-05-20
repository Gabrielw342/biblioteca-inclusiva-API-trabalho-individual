package com.biblioteca.bibliotecainclusa.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class PerfilAcessibilidadeResponseDTO {

    @Schema(description = "ID do perfil de acessibilidade", example = "1")
    private Long id;

    @Schema(description = "Tipo de acessibilidade (braile, áudio livro, leitor de tela, fonte grande)", example = "braile")
    private String tipoAcessibilidade;

    @Schema(description = "Descrição da acessibilidade", example = "Versão do livro em braile para leitura tátil")
    private String descricao;

    public PerfilAcessibilidadeResponseDTO() {
    }

    public PerfilAcessibilidadeResponseDTO(Long id, String tipoAcessibilidade, String descricao) {
        this.id = id;
        this.tipoAcessibilidade = tipoAcessibilidade;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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