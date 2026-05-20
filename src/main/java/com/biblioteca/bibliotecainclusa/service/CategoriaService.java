package com.biblioteca.bibliotecainclusa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.bibliotecainclusa.dto.request.CategoriaRequestDTO;
import com.biblioteca.bibliotecainclusa.dto.response.CategoriaResponseDTO;
import com.biblioteca.bibliotecainclusa.entity.Categoria;
import com.biblioteca.bibliotecainclusa.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<CategoriaResponseDTO> listar() {
        return repository.findAll().stream()
                .map(categoria -> new CategoriaResponseDTO(
                        categoria.getNome()))
                .collect(Collectors.toList());
    }

    public CategoriaResponseDTO salvar(CategoriaRequestDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());

        Categoria categoriaSalva = repository.save(categoria);

        return new CategoriaResponseDTO(
                categoriaSalva.getNome());
    }
}