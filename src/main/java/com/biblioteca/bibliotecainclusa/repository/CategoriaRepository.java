package com.biblioteca.bibliotecainclusa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.biblioteca.bibliotecainclusa.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}