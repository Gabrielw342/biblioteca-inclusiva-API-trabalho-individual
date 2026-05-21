package com.biblioteca.bibliotecainclusa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.bibliotecainclusa.dto.request.PerfilAcessibilidadeRequestDTO;
import com.biblioteca.bibliotecainclusa.dto.response.PerfilAcessibilidadeResponseDTO;
import com.biblioteca.bibliotecainclusa.entity.PerfilAcessibilidade;
import com.biblioteca.bibliotecainclusa.exception.ResourceNotFoundException;
import com.biblioteca.bibliotecainclusa.repository.PerfilAcessibilidadeRepository;

@Service
public class PerfilAcessibilidadeService {

    @Autowired
    private PerfilAcessibilidadeRepository repository;

    public List<PerfilAcessibilidadeResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public PerfilAcessibilidadeResponseDTO buscarPorId(Long id) {
        PerfilAcessibilidade perfil = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Perfil não encontrado"));

        return converterParaDTO(perfil);
    }

    public PerfilAcessibilidadeResponseDTO salvar(PerfilAcessibilidadeRequestDTO dto) {

        PerfilAcessibilidade perfil = new PerfilAcessibilidade();
        perfil.setTipoNecessidade(dto.getTipoNecessidade());

        PerfilAcessibilidade salvo = repository.save(perfil);

        return converterParaDTO(salvo);
    }

    public PerfilAcessibilidadeResponseDTO atualizar(Long id, PerfilAcessibilidadeRequestDTO dto) {

        PerfilAcessibilidade perfil = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Perfil não encontrado"));

        perfil.setTipoNecessidade(dto.getTipoNecessidade());

        PerfilAcessibilidade atualizado = repository.save(perfil);

        return converterParaDTO(atualizado);
    }

    public void deletar(Long id) {

        PerfilAcessibilidade perfil = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Perfil não encontrado"));

        repository.delete(perfil);
    }

    private PerfilAcessibilidadeResponseDTO converterParaDTO(PerfilAcessibilidade perfil) {
        return new PerfilAcessibilidadeResponseDTO(
                perfil.getId(),
                perfil.getTipoNecessidade()
        );
    }
}