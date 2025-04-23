package com.example.agencia_viagens.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "usuario")
public class Usuario {

   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    private String papel;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {
    }

    
 
}
