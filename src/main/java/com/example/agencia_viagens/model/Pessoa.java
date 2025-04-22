package com.example.agencia_viagens.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Pessoa {

    @NotNull
    @Size(min = 3, max = 255)
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "email", unique = true)
    private String email;

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public abstract String obterDescricao();

    @Override
    public String toString() {
        return String.format("Nome: %s, Email: %s", nome, email);
    }
}
