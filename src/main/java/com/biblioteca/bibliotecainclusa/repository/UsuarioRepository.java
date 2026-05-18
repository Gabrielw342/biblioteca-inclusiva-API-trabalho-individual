package com.biblioteca.bibliotecainclusa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.biblioteca.bibliotecainclusa.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}