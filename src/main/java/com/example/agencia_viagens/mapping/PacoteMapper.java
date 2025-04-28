package com.example.agencia_viagens.mapping;

import java.time.format.DateTimeFormatter;

import com.example.agencia_viagens.dto.PacoteDTO;
import com.example.agencia_viagens.model.Pacote;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacoteMapper {
    
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

  public PacoteMapper(Pacote pacote) {

    this.idPacote = pacote.getIdPacote();
    this.titulo=pacote.getTitulo();
    this.descricao=pacote.getDescricao();
    this.dataPartida=pacote.getDataPartida().toString();
    this.dataChegada=pacote.getDataChegada().toString();
    this.estado=pacote.getEstado();
    this.hospedagem=pacote.getHospedagem();
    this.passeios=pacote.getPasseios();
    this.translado=pacote.getTranslado();
    this.valor=pacote.getValor();
  }

  public static PacoteDTO toDto(Pacote pacote) {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    PacoteDTO dto = new PacoteDTO();
    dto.setIdPacote(pacote.getIdPacote());
    dto.setTitulo(pacote.getTitulo());
    dto.setDescricao(pacote.getDescricao());
    dto.setDataPartida(pacote.getDataPartida().format(formatter));
    dto.setDataChegada(pacote.getDataChegada().format(formatter));
    dto.setEstado(pacote.getEstado());
    dto.setHospedagem(pacote.getHospedagem());
    dto.setPasseios(pacote.getPasseios());
    dto.setTranslado(pacote.getTranslado());
    dto.setValor(pacote.getValor());

    return dto;
  }
    
}