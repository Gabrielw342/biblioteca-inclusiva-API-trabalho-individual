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
        return repository.findAll().stream()
                .map(e -> new EmprestimoResponseDTO(
                        e.getDataEmprestimo(),
                        e.getDataDevolucao(),
                        e.getUsuario().getNome(),
                        e.getLivro().getTitulo()))
                .collect(Collectors.toList());
    }

    public EmprestimoResponseDTO salvar(EmprestimoRequestDTO dto) {

    	Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
    	        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    	Livro livro = livroRepository.findById(dto.getLivroId())
    	        .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        Emprestimo emprestimo = new Emprestimo();

        emprestimo.setDataEmprestimo(dto.getDataEmprestimo());
        emprestimo.setDataDevolucao(dto.getDataDevolucao());
        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);

        repository.save(emprestimo);

        return new EmprestimoResponseDTO(
                emprestimo.getDataEmprestimo(),
                emprestimo.getDataDevolucao(),
                usuario.getNome(),
                livro.getTitulo());
    }
}