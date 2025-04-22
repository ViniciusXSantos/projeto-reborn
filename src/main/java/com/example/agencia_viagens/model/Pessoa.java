package com.example.agencia_viagens.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
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
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull
    @Email(message = "E-mail inválido")
    @Size(max = 255)
    @Column(name = "email", nullable = false)
    private String email;

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public abstract String obterDescricao();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
               "nome='" + nome + '\'' +
               ", email='" + email + '\'' +
               '}';
    }
}