package com.example.agencia_viagens.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pacote {

    @NotEmpty
    private String viagem;

    @NotNull
    private String descricao;

    @NotNull
    private LocalDate dataPartida;

    @NotNull
    private LocalDate dataChegada;
    
}
