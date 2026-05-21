package com.biblioteca.bibliotecainclusa.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biblioteca.bibliotecainclusa.dto.request.LivroRequestDTO;
import com.biblioteca.bibliotecainclusa.dto.response.LivroResponseDTO;
import com.biblioteca.bibliotecainclusa.entity.Categoria;
import com.biblioteca.bibliotecainclusa.entity.Livro;
import com.biblioteca.bibliotecainclusa.exception.ResourceNotFoundException;
import com.biblioteca.bibliotecainclusa.repository.CategoriaRepository;
import com.biblioteca.bibliotecainclusa.repository.EmprestimoRepository;
import com.biblioteca.bibliotecainclusa.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public Page<LivroResponseDTO> listar(Pageable pageable) {
        return livroRepository.findAll(pageable)
                .map(this::converterParaDTO);
    }

    public LivroResponseDTO buscarPorId(Long id) {

        Livro livro = livroRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Livro não encontrado"));

        return converterParaDTO(livro);
    }

    public LivroResponseDTO salvar(LivroRequestDTO dto) {

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Categoria não encontrada"));

        Livro livro = new Livro();
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setEditora(dto.getEditora());
        livro.setIsbn(dto.getIsbn());
        livro.setAnoLancamento(dto.getAnoLancamento());
        livro.setCategoria(categoria);

        Livro livroSalvo = livroRepository.save(livro);

        return converterParaDTO(livroSalvo);
    }

    @Transactional
    public void deletar(Long id) {

        Livro livro = livroRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Livro não encontrado"));

        emprestimoRepository.deleteByLivroId(id);

        livroRepository.delete(livro);
    }

    public LivroResponseDTO atualizar(Long id, LivroRequestDTO dto) {

        Livro livro = livroRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Livro não encontrado"));

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Categoria não encontrada"));

        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setEditora(dto.getEditora());
        livro.setIsbn(dto.getIsbn());
        livro.setAnoLancamento(dto.getAnoLancamento());
        livro.setCategoria(categoria);

        Livro atualizado = livroRepository.save(livro);

        return converterParaDTO(atualizado);
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