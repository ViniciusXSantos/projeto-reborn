package com.example.agencia_viagens.model;

import java.time.LocalDate;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "pacote")
public class Pacote {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(nullable = false)
    private String viagem;

    @Column( nullable = true)
    private String descricao;

    @Column(nullable = false)
    private LocalDate dataPartida;

   @Column(nullable = false)
    private LocalDate dataChegada;

   
    public Pacote(String viagem,String descricao,LocalDate dataPartida, LocalDate dataChegada) {
        this.viagem =viagem;
        this.descricao=descricao;
        this.dataPartida=dataPartida;
        this.dataChegada=dataChegada;
    
    }

    public Pacote() {
    }

    
 
}
