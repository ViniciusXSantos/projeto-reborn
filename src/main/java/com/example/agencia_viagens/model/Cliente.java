package com.example.agencia_viagens.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email") // Apenas email é único
})
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true) // Email único
    private String email;

    @Column(nullable = false)
    private String telefone1;

    private String telefone2;

    @Column(nullable = false)
    private String tipoTelefone1;

    private String tipoTelefone2;

    // Endereço
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String numero;
    private String complemento;
}