package com.biblioteca.bibliotecainclusa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.bibliotecainclusa.dto.request.PerfilAcessibilidadeRequestDTO;
import com.biblioteca.bibliotecainclusa.dto.response.PerfilAcessibilidadeResponseDTO;
import com.biblioteca.bibliotecainclusa.entity.PerfilAcessibilidade;
import com.biblioteca.bibliotecainclusa.entity.Usuario;
import com.biblioteca.bibliotecainclusa.exception.ResourceNotFoundException;
import com.biblioteca.bibliotecainclusa.repository.PerfilAcessibilidadeRepository;
import com.biblioteca.bibliotecainclusa.repository.UsuarioRepository;

@Service
public class PerfilAcessibilidadeService {

    @Autowired
    private PerfilAcessibilidadeRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

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

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        PerfilAcessibilidade perfil = new PerfilAcessibilidade();
        perfil.setTipoNecessidade(dto.getTipoNecessidade());
        perfil.setUsuario(usuario);

        return converterParaDTO(repository.save(perfil));
    }

    public PerfilAcessibilidadeResponseDTO atualizar(Long id, PerfilAcessibilidadeRequestDTO dto) {

        PerfilAcessibilidade perfil = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Perfil não encontrado"));

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        perfil.setTipoNecessidade(dto.getTipoNecessidade());
        perfil.setUsuario(usuario);

        return converterParaDTO(repository.save(perfil));
    }

    public void deletar(Long id) {

        PerfilAcessibilidade perfil = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Perfil não encontrado"));

        repository.delete(perfil);
    }

    private PerfilAcessibilidadeResponseDTO converterParaDTO(PerfilAcessibilidade perfil) {
        return new PerfilAcessibilidadeResponseDTO(
                perfil.getTipoNecessidade(),
                perfil.getUsuario().getNome()
        );
    }
}