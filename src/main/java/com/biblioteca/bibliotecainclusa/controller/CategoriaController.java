package com.biblioteca.bibliotecainclusa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.biblioteca.bibliotecainclusa.dto.request.CategoriaRequestDTO;
import com.biblioteca.bibliotecainclusa.dto.response.CategoriaResponseDTO;
import com.biblioteca.bibliotecainclusa.service.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
@Validated
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public List<CategoriaResponseDTO> listar() {
        return service.listar();
    }

    @PostMapping
    public CategoriaResponseDTO salvar(@Valid @RequestBody CategoriaRequestDTO dto) {
        return service.salvar(dto);
    }
}