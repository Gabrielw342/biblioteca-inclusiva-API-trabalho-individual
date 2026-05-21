package com.biblioteca.bibliotecainclusa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.biblioteca.bibliotecainclusa.dto.request.PerfilAcessibilidadeRequestDTO;
import com.biblioteca.bibliotecainclusa.dto.response.PerfilAcessibilidadeResponseDTO;
import com.biblioteca.bibliotecainclusa.service.PerfilAcessibilidadeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/perfilacessibilidade")
@Tag(
    name = "Perfis de Acessibilidade",
    description = "Gerenciamento de perfis de acessibilidade dos usuários"
)
public class PerfilAcessibilidadeController {

    @Autowired
    private PerfilAcessibilidadeService service;

    @GetMapping
    @Operation(summary = "Listar perfis de acessibilidade", description = "Retorna todos os perfis cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de perfis retornada com sucesso")
    public List<PerfilAcessibilidadeResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar perfil por ID", description = "Retorna um perfil específico pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Perfil encontrado"),
            @ApiResponse(responseCode = "404", description = "Perfil não encontrado")
    })
    public PerfilAcessibilidadeResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Criar perfil de acessibilidade", description = "Cadastra um novo perfil no sistema")
    @ApiResponse(responseCode = "200", description = "Perfil criado com sucesso")
    public PerfilAcessibilidadeResponseDTO salvar(@RequestBody PerfilAcessibilidadeRequestDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar perfil", description = "Atualiza um perfil existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Perfil atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Perfil não encontrado")
    })
    public PerfilAcessibilidadeResponseDTO atualizar(
            @PathVariable Long id,
            @RequestBody PerfilAcessibilidadeRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover perfil", description = "Remove um perfil pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Perfil removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Perfil não encontrado")
    })
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}