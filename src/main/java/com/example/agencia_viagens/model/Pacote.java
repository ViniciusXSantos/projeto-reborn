package com.example.agencia_viagens.model;

import java.time.LocalDate;
import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Data
@Entity
@Table(name = "pacote")
public class Pacote {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O título do pacote é obrigatório.")
    @Column(nullable = false)
    private String viagem;

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

    @NotNull(message = "O valor é obrigatório.")
    @Column(nullable = false)
    private double valor;


    @NotNull(message = "O pacote deve estar associado a uma hospedagem.")
    @ManyToOne(optional = false)
    @JoinColumn(name = "hospedagem_id")
    private Hospedagem hospedagem;
   
    public Pacote(String viagem,String descricao,LocalDate dataPartida, LocalDate dataChegada,double valor) {
        this.viagem =viagem;
        this.descricao=descricao;
        this.dataPartida=dataPartida;
        this.dataChegada=dataChegada;
        this.valor=valor;
    
    }

    public Pacote() {
    }

    
 
}
