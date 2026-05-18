package com.biblioteca.bibliotecainclusa.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "emprestimo")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataEmprestimo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
        name = "emprestimo_livro",
        joinColumns = @JoinColumn(name = "emprestimo_id"),
        inverseJoinColumns = @JoinColumn(name = "livro_id")
    )
    private List<Livro> livros;

    public Emprestimo() {
    }

    public Emprestimo(Long id, LocalDate dataEmprestimo, Usuario usuario, List<Livro> livros) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.usuario = usuario;
        this.livros = livros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}