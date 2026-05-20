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

    @PostMapping
    @Operation(summary = "Cadastra um novo livro com acessibilidade")
    public LivroResponseDTO salvar(@Valid @RequestBody LivroRequestDTO dto) {
        return service.salvar(dto);
    }
}