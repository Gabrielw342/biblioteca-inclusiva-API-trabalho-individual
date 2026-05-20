package com.biblioteca.bibliotecainclusa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.biblioteca.bibliotecainclusa.entity.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    void deleteByLivroId(Long livroId);

    List<Emprestimo> findByLivroId(Long livroId);
}