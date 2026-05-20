package com.biblioteca.bibliotecainclusa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.biblioteca.bibliotecainclusa.dto.request.CategoriaRequestDTO;
import com.biblioteca.bibliotecainclusa.dto.response.CategoriaResponseDTO;
import com.biblioteca.bibliotecainclusa.service.CategoriaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
@Validated
@Tag(name = "Categorias", description = "Gerenciamento de categorias de livros")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    @Operation(summary = "Lista todas as categorias")
    public List<CategoriaResponseDTO> listar() {
        return service.listar();
    }

    @PostMapping
    @Operation(summary = "Cria uma nova categoria")
    public CategoriaResponseDTO salvar(@Valid @RequestBody CategoriaRequestDTO dto) {
        return service.salvar(dto);
    }
}