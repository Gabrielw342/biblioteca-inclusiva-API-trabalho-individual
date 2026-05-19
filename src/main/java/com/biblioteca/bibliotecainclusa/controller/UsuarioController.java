package com.biblioteca.bibliotecainclusa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.biblioteca.bibliotecainclusa.dto.request.UsuarioRequestDTO;
import com.biblioteca.bibliotecainclusa.dto.response.UsuarioResponseDTO;
import com.biblioteca.bibliotecainclusa.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
@Validated
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<UsuarioResponseDTO> listar() {
        return service.listar();
    }

    @PostMapping
    public UsuarioResponseDTO salvar(@Valid @RequestBody UsuarioRequestDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}