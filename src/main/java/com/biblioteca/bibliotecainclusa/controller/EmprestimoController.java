package com.biblioteca.bibliotecainclusa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.bibliotecainclusa.dto.request.EmprestimoRequestDTO;
import com.biblioteca.bibliotecainclusa.dto.response.EmprestimoResponseDTO;
import com.biblioteca.bibliotecainclusa.service.EmprestimoService;

import jakarta.validation.Valid;

@RestController
@Validated
public class EmprestimoController {

    @Autowired
    private EmprestimoService service;

    @GetMapping("/emprestimos")
    public List<EmprestimoResponseDTO> listar() {
        return service.listar();
    }

    @PostMapping("/emprestimos")
    public EmprestimoResponseDTO salvar(@Valid @RequestBody EmprestimoRequestDTO dto) {
        return service.salvar(dto);
    }
}