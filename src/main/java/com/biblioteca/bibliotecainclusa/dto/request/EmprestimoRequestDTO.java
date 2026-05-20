package com.biblioteca.bibliotecainclusa.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class EmprestimoRequestDTO {

    @NotNull(message = "Data do empréstimo é obrigatória")
    private LocalDate dataEmprestimo;

    @NotNull(message = "Data da devolução é obrigatória")
    private LocalDate dataDevolucao;

    @NotNull(message = "Usuário é obrigatório")
    private Long usuarioId;

    @NotNull(message = "Livro é obrigatório")
    private Long livroId;

    public EmprestimoRequestDTO() {
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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }
}