package com.biblioteca.bibliotecainclusa.dto.response;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

public class EmprestimoResponseDTO {

    @Schema(description = "Data em que o livro foi emprestado", example = "2026-05-19")
    private LocalDate dataEmprestimo;

    @Schema(description = "Data prevista de devolução do livro", example = "2026-05-26")
    private LocalDate dataDevolucao;

    @Schema(description = "Nome do usuário que pegou o livro", example = "Ray Valdo")
    private String usuario;

    @Schema(description = "Título do livro emprestado", example = "Como treinar seu dragão")
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

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getLivro() {
        return livro;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }
}