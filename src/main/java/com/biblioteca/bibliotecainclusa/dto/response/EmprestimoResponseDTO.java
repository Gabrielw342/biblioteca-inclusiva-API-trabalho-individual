package com.biblioteca.bibliotecainclusa.dto.response;

import java.time.LocalDate;

public class EmprestimoResponseDTO {

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private String usuario;
    private String livro;

    public EmprestimoResponseDTO() {
    }

    public EmprestimoResponseDTO(LocalDate dataEmprestimo, LocalDate dataDevolucao, String usuario, String livro) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.usuario = usuario;
        this.livro = livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }
}