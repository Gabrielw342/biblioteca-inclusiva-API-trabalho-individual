package com.biblioteca.bibliotecainclusa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.bibliotecainclusa.dto.request.CategoriaRequestDTO;
import com.biblioteca.bibliotecainclusa.dto.response.CategoriaResponseDTO;
import com.biblioteca.bibliotecainclusa.entity.Categoria;
import com.biblioteca.bibliotecainclusa.exception.DuplicateEntryException;
import com.biblioteca.bibliotecainclusa.exception.ResourceNotFoundException;
import com.biblioteca.bibliotecainclusa.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<CategoriaResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(c -> new CategoriaResponseDTO(c.getNome()))
                .collect(Collectors.toList());
    }

    public CategoriaResponseDTO buscarPorId(Long id) {
        Categoria categoria = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));

        return new CategoriaResponseDTO(categoria.getNome());
    }

    public CategoriaResponseDTO salvar(CategoriaRequestDTO dto) {

        if (repository.existsByNome(dto.getNome())) {
            throw new DuplicateEntryException("Categoria já existe");
        }

        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());

        Categoria salva = repository.save(categoria);

        return new CategoriaResponseDTO(salva.getNome());
    }

    public CategoriaResponseDTO atualizar(Long id, CategoriaRequestDTO dto) {

        Categoria categoria = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));

       
        if (repository.existsByNome(dto.getNome()) &&
            !categoria.getNome().equals(dto.getNome())) {
            throw new DuplicateEntryException("Categoria já existe");
        }

        categoria.setNome(dto.getNome());

        Categoria atualizada = repository.save(categoria);

        return new CategoriaResponseDTO(atualizada.getNome());
    }

    public void deletar(Long id) {

        Categoria categoria = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));

        repository.delete(categoria);
    }
}