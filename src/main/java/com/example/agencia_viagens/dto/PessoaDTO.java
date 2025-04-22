package com.example.agencia_viagens.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PessoaDTO {

    @NotNull
    @Size(min = 3, max = 255)
    private String nome;

    @NotNull
    @Email
    private String email;
}
