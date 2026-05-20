package com.biblioteca.bibliotecainclusa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.biblioteca.bibliotecainclusa.dto.request.CategoriaRequestDTO;
import com.biblioteca.bibliotecainclusa.dto.response.CategoriaResponseDTO;
import com.biblioteca.bibliotecainclusa.service.CategoriaService;

import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/categorias")
@Validated
@Tag(name = "Categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public List<CategoriaResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public CategoriaResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public CategoriaResponseDTO salvar(@Valid @RequestBody CategoriaRequestDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public CategoriaResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody CategoriaRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}