package com.biblioteca.bibliotecainclusa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.biblioteca.bibliotecainclusa.dto.request.EmprestimoRequestDTO;
import com.biblioteca.bibliotecainclusa.dto.response.EmprestimoResponseDTO;
import com.biblioteca.bibliotecainclusa.service.EmprestimoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/emprestimos")
@Validated
@Tag(name = "Empréstimos", description = "Gerenciamento de empréstimos de livros da biblioteca")
public class EmprestimoController {

    @Autowired
    private EmprestimoService service;

    @GetMapping
    @Operation(summary = "Listar todos os empréstimos", description = "Retorna todos os empréstimos cadastrados no sistema")
    @ApiResponse(responseCode = "200", description = "Lista de empréstimos retornada com sucesso")
    public List<EmprestimoResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar empréstimo por ID", description = "Retorna um empréstimo específico pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empréstimo encontrado"),
            @ApiResponse(responseCode = "404", description = "Empréstimo não encontrado")
    })
    public EmprestimoResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Criar empréstimo", description = "Registra um novo empréstimo de livro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empréstimo criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos!")
    })
    public EmprestimoResponseDTO salvar(@Valid @RequestBody EmprestimoRequestDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar empréstimo", description = "Atualiza um empréstimo existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empréstimo atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Empréstimo não encontrado")
    })
    public EmprestimoResponseDTO atualizar(
            @PathVariable Long id,
            @Valid @RequestBody EmprestimoRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover empréstimo", description = "Remove um empréstimo pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Empréstimo removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Empréstimo não encontrado")
    })
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}