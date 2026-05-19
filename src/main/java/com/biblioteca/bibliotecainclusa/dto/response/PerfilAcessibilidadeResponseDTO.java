package com.biblioteca.bibliotecainclusa.dto.response;

public class PerfilAcessibilidadeResponseDTO {

    private Long id;
    private String tipoAcessibilidade;
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