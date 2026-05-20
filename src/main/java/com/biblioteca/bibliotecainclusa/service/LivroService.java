package com.biblioteca.bibliotecainclusa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.bibliotecainclusa.dto.request.LivroRequestDTO;
import com.biblioteca.bibliotecainclusa.dto.response.LivroResponseDTO;
import com.biblioteca.bibliotecainclusa.entity.Categoria;
import com.biblioteca.bibliotecainclusa.entity.Livro;
import com.biblioteca.bibliotecainclusa.repository.CategoriaRepository;
import com.biblioteca.bibliotecainclusa.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<LivroResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public LivroResponseDTO salvar(LivroRequestDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId()).orElse(null);

        Livro livro = new Livro();
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setEditora(dto.getEditora());
        livro.setIsbn(dto.getIsbn());
        livro.setAnoLancamento(dto.getAnoLancamento());
        livro.setCategoria(categoria);

        Livro livroSalvo = repository.save(livro);

        return converterParaDTO(livroSalvo);
    }

    private LivroResponseDTO converterParaDTO(Livro livro) {
        return new LivroResponseDTO(
                livro.getTitulo(),
                livro.getAutor(),
                livro.getEditora(),
                livro.getIsbn(),
                livro.getAnoLancamento(),
                livro.getCategoria().getNome()
        );
    }
}