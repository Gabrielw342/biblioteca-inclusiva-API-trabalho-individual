package com.biblioteca.bibliotecainclusa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.bibliotecainclusa.dto.request.UsuarioRequestDTO;
import com.biblioteca.bibliotecainclusa.dto.response.UsuarioResponseDTO;
import com.biblioteca.bibliotecainclusa.entity.Usuario;
import com.biblioteca.bibliotecainclusa.exception.ResourceNotFoundException;
import com.biblioteca.bibliotecainclusa.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::converterParaResponseDTO)
                .collect(Collectors.toList());
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        return converterParaResponseDTO(usuario);
    }

    public UsuarioResponseDTO salvar(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setCpf(dto.getCpf());

        Usuario salvo = repository.save(usuario);

        return converterParaResponseDTO(salvo);
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setCpf(dto.getCpf());

        Usuario atualizado = repository.save(usuario);

        return converterParaResponseDTO(atualizado);
    }

    public void deletar(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        repository.delete(usuario);
    }

    private UsuarioResponseDTO converterParaResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getNome(),
                usuario.getEmail()
        );
    }
}