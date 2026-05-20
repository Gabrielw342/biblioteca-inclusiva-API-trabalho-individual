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
import jakarta.validation.Valid;

@RestController
@RequestMapping("/emprestimos")
@Validated
@Tag(name = "Empréstimos", description = "Gerenciamento de empréstimos de livros")
public class EmprestimoController {

    @Autowired
    private EmprestimoService service;

    @GetMapping
    @Operation(summary = "Lista todos os empréstimos")
    public List<EmprestimoResponseDTO> listar() {
        return service.listar();
    }

    @PostMapping
    @Operation(summary = "Cria um novo empréstimo de livro")
    public EmprestimoResponseDTO salvar(@Valid @RequestBody EmprestimoRequestDTO dto) {
        return service.salvar(dto);
    }
}