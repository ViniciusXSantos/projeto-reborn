package com.example.agencia_viagens.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelefoneDTO {

    private Long id;

    @NotNull
    private String numero;

    @NotNull
    private String tipo;
}
