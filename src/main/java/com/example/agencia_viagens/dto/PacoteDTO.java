package com.example.agencia_viagens.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class PacoteDTO {

    @NotBlank(message = "O título do pacote é obrigatório.")
    private String viagem;

    private String descricao;

    @NotNull(message = "A data de partida é obrigatória.")
    @FutureOrPresent(message = "A data de partida deve ser hoje ou futura.")
    private LocalDate dataPartida;

    @NotNull(message = "A data de chegada é obrigatória.")
    @FutureOrPresent(message = "A data de chegada deve ser hoje ou futura.")
    private LocalDate dataChegada;

    @NotNull(message = "O valor é obrigatório.")
     private double valor;
    
    
}
