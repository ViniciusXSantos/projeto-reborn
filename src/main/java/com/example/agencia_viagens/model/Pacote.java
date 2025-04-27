package com.example.agencia_viagens.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.validation.constraints.*;

@Entity
@Data
@Table(name = "pacote")
public class Pacote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pacote")
    private Long idPacote;

    //@Lob
    //private byte[] imagem;

    @NotEmpty
    @NotBlank(message = "O título do pacote é obrigatório.")
    @Column(nullable = false)
    private String titulo;

    @Column(nullable = true)
    private String descricao;

    @NotNull(message = "A data de partida é obrigatória.")
    @FutureOrPresent(message = "A data de partida deve ser hoje ou no futuro.")
    @Column(nullable = false)
    private LocalDate dataPartida;

    @NotNull(message = "A data de chegada é obrigatória.")
    @FutureOrPresent(message = "A data de chegada deve ser hoje ou no futuro.")
    @Column(nullable = false)
    private LocalDate dataChegada;

    private String estado;
    private String hospedagem;
    private String passeios;
    private String translado;
    private String valor;
}
