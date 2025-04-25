package com.example.agencia_viagens.dto;

import lombok.Data;

@Data
public class ClienteDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone1;
    private String telefone2;
    private String tipoTelefone1;
    private String tipoTelefone2;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String numero;
    private String complemento;
}