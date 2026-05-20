package com.biblioteca.bibliotecainclusa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.biblioteca.bibliotecainclusa.dto.request.UsuarioRequestDTO;
import com.biblioteca.bibliotecainclusa.dto.response.UsuarioResponseDTO;
import com.biblioteca.bibliotecainclusa.service.UsuarioService;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/usuarios")
@Validated
@Tag(name = "Usuários", description = "Gerenciamento de usuários da biblioteca")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    @Operation(summary = "Listar usuários", description = "Retorna todos os usuários cadastrados")
    public List<UsuarioResponseDTO> listar() {
        return service.listar();
    }

    @PostMapping
    @Operation(summary = "Criar usuário", description = "Cadastra um novo usuário na biblioteca")
    public UsuarioResponseDTO salvar(@Valid @RequestBody UsuarioRequestDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuário por ID", description = "Retorna um usuário pela sua ID")
    public UsuarioResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar usuário", description = "Remove um usuário pelo ID")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}