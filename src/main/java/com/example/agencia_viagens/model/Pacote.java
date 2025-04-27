package com.example.agencia_viagens.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String titulo;

    @NotNull
    private String descricao;

    @NotNull
    private LocalDate dataPartida;

    @NotNull
    private LocalDate dataChegada;

    private String estado;

    private String hospedagem;

    private String passeios;

    private String translado;

    private String valor;
    
/*
     public Pacote (
      
        String titulo,
        String descricao,
        LocalDate dataPartida,
        LocalDate dataChegada

    ) {
 
        this.titulo =titulo;
        this.descricao =descricao;
        this.dataPartida= dataPartida;
        this.dataChegada=dataChegada;

    }
 */


}
