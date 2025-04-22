package com.example.agencia_viagens.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClienteDTO extends PessoaDTO {
    private Long idCliente;
    private List<TelefoneDTO> telefones;
    private List<EnderecoDTO> enderecos;
}
