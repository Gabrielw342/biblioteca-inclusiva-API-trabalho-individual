package com.biblioteca.bibliotecainclusa.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

public class EmprestimoRequestDTO {

    @NotNull(message = "Data do empréstimo é obrigatória")
    @Schema(description = "Data em que o livro foi emprestado", example = "2026-05-19")
    private LocalDate dataEmprestimo;

    @NotNull(message = "Data da devolução é obrigatória")
    @Schema(description = "Data prevista para devolução do livro", example = "2026-05-26")
    private LocalDate dataDevolucao;

    @NotNull(message = "Usuário é obrigatório")
    @Schema(description = "ID do usuário que está pegando o livro", example = "1")
    private Long usuarioId;

    @NotNull(message = "Livro é obrigatório")
    @Schema(description = "ID do livro emprestado", example = "69")
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