package com.biblioteca.bibliotecainclusa.dto.response;

public class UsuarioResponseDTO {

    private String nome;
    private String email;
   

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(Long id, String nome, String email, String cpf) {
        
        this.nome = nome;
        this.email = email;
       
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
  
    }
}