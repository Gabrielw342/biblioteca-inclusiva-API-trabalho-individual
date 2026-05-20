package com.biblioteca.bibliotecainclusa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.bibliotecainclusa.dto.request.LivroRequestDTO;
import com.biblioteca.bibliotecainclusa.dto.response.LivroResponseDTO;
import com.biblioteca.bibliotecainclusa.service.LivroService;

import jakarta.validation.Valid;

@RestController
@Validated
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping("/livros")
    public List<LivroResponseDTO> listar() {
        return service.listar();
    }

    @PostMapping("/livros")
    public LivroResponseDTO salvar(@Valid @RequestBody LivroRequestDTO dto) {
        return service.salvar(dto);
    }
}