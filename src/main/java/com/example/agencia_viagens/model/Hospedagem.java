package com.example.agencia_viagens.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "hospedagens")
public class Hospedagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String telefone1;

    @Column(unique = true)
    private String telefone2;

    @Column(nullable = false)
    private String tipoTelefone1;

    private String tipoTelefone2;

    @Column(nullable = false)
    private String pais;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String numero;

    private String complemento;
}
