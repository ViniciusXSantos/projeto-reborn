package com.example.agencia_viagens.dto;

import java.time.LocalDate;

import com.example.agencia_viagens.model.Pacote;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PacoteDTO {

    private Long idPacote;
    private String titulo;
    private String descricao;
    private String dataPartida;
    private String dataChegada;
    private String estado;
    private String hospedagem;
    private String passeios;
    private String translado;
    private String valor;

    public PacoteDTO (
        Long idPacote,
        String titulo,
        String descricao,
        String dataPartida,
        String dataChegada,
        String estado,
        String hospedagem,
        String passeios,
        String translado,
        String valor
    ) {
        this.idPacote = idPacote;
        this.titulo =titulo;
        this.descricao =descricao;
        this.dataPartida=dataPartida;
        this.dataChegada=dataChegada;
        this.estado=estado;
        this.hospedagem=hospedagem;
        this.passeios=passeios;
        this.translado=translado;
        this.valor=valor;
    }   
    
    
    public Pacote toEntity() {
        Pacote pacote = new Pacote();
        pacote.setIdPacote(this.idPacote);
        pacote.setTitulo(this.titulo);
        pacote.setDescricao(this.descricao);
        pacote.setDataPartida(LocalDate.parse(this.dataPartida));
        pacote.setDataChegada(LocalDate.parse(this.dataChegada));
        pacote.setEstado(this.estado);
        pacote.setHospedagem(this.hospedagem);
        pacote.setPasseios(this.passeios);
        pacote.setTranslado(this.translado);
        pacote.setValor(this.valor);
        return pacote;
    }


}
