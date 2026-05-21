package com.biblioteca.bibliotecainclusa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.bibliotecainclusa.dto.request.EmprestimoRequestDTO;
import com.biblioteca.bibliotecainclusa.dto.response.EmprestimoResponseDTO;
import com.biblioteca.bibliotecainclusa.entity.Emprestimo;
import com.biblioteca.bibliotecainclusa.entity.Livro;
import com.biblioteca.bibliotecainclusa.entity.Usuario;
import com.biblioteca.bibliotecainclusa.exception.ResourceNotFoundException;
import com.biblioteca.bibliotecainclusa.repository.EmprestimoRepository;
import com.biblioteca.bibliotecainclusa.repository.LivroRepository;
import com.biblioteca.bibliotecainclusa.repository.UsuarioRepository;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LivroRepository livroRepository;

    public List<EmprestimoResponseDTO> listar() {

        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public EmprestimoResponseDTO buscarPorId(Long id) {

        Emprestimo emprestimo = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Empréstimo não encontrado"));

        return converterParaDTO(emprestimo);
    }

    public EmprestimoResponseDTO salvar(EmprestimoRequestDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuário não encontrado"));

        Livro livro = livroRepository.findById(dto.getLivroId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Livro não encontrado"));

        Emprestimo emprestimo = new Emprestimo();

        emprestimo.setDataEmprestimo(dto.getDataEmprestimo());
        emprestimo.setDataDevolucao(dto.getDataDevolucao());
        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);

        Emprestimo emprestimoSalvo = repository.save(emprestimo);

        return converterParaDTO(emprestimoSalvo);
    }

    public EmprestimoResponseDTO atualizar(Long id, EmprestimoRequestDTO dto) {

        Emprestimo emprestimo = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Empréstimo não encontrado"));

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuário não encontrado"));

        Livro livro = livroRepository.findById(dto.getLivroId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Livro não encontrado"));

        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);
        emprestimo.setDataEmprestimo(dto.getDataEmprestimo());
        emprestimo.setDataDevolucao(dto.getDataDevolucao());

        Emprestimo atualizado = repository.save(emprestimo);

        return converterParaDTO(atualizado);
    }

    public void deletar(Long id) {

        Emprestimo emprestimo = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Empréstimo não encontrado"));

        repository.delete(emprestimo);
    }

    private EmprestimoResponseDTO converterParaDTO(Emprestimo emprestimo) {

        return new EmprestimoResponseDTO(
                emprestimo.getDataEmprestimo(),
                emprestimo.getDataDevolucao(),
                emprestimo.getUsuario().getNome(),
                emprestimo.getLivro().getTitulo()
        );
    }
}