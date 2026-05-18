package com.biblioteca.bibliotecainclusa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "perfil_acessibilidade")
public class PerfilAcessibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoNecessidade;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public PerfilAcessibilidade() {
    }

    public PerfilAcessibilidade(Long id, String tipoNecessidade, Usuario usuario) {
        this.id = id;
        this.tipoNecessidade = tipoNecessidade;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoNecessidade() {
        return tipoNecessidade;
    }

    public void setTipoNecessidade(String tipoNecessidade) {
        this.tipoNecessidade = tipoNecessidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}