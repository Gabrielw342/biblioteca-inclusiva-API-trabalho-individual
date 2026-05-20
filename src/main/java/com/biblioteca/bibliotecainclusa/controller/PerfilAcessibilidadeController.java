package com.biblioteca.bibliotecainclusa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.biblioteca.bibliotecainclusa.dto.request.PerfilAcessibilidadeRequestDTO;
import com.biblioteca.bibliotecainclusa.dto.response.PerfilAcessibilidadeResponseDTO;
import com.biblioteca.bibliotecainclusa.service.PerfilAcessibilidadeService;

@RestController
@RequestMapping("/perfilacessibilidade")
public class PerfilAcessibilidadeController {

    @Autowired
    private PerfilAcessibilidadeService service;

    @GetMapping
    public List<PerfilAcessibilidadeResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public PerfilAcessibilidadeResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public PerfilAcessibilidadeResponseDTO salvar(@RequestBody PerfilAcessibilidadeRequestDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public PerfilAcessibilidadeResponseDTO atualizar(@PathVariable Long id,
                                                     @RequestBody PerfilAcessibilidadeRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}