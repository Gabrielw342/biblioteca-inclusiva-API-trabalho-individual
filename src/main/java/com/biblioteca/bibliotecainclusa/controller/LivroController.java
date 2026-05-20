package com.biblioteca.bibliotecainclusa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.biblioteca.bibliotecainclusa.dto.request.LivroRequestDTO;
import com.biblioteca.bibliotecainclusa.dto.response.LivroResponseDTO;
import com.biblioteca.bibliotecainclusa.service.LivroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
@Validated
@Tag(name = "Livros", description = "Gerenciamento de livros da biblioteca inclusiva")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping
    @Operation(summary = "Lista todos os livros")
    public List<LivroResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca livro por ID")
    public LivroResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Cadastra um novo livro com acessibilidade")
    public LivroResponseDTO salvar(@Valid @RequestBody LivroRequestDTO dto) {
        return service.salvar(dto);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um livro pelo ID")
    public LivroResponseDTO atualizar(
            @PathVariable Long id,
            @Valid @RequestBody LivroRequestDTO dto) {
        return service.atualizar(id, dto);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um livro pelo ID")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}