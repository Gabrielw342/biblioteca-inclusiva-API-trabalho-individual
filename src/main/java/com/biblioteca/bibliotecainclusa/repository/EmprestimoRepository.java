package com.biblioteca.bibliotecainclusa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.biblioteca.bibliotecainclusa.entity.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}