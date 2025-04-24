package com.example.agencia_viagens.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HospedagemDTO {

    private Long id;

    private String nome;

    private String telefone1;

    private String telefone2;

    private String logradouro;

    private String numero;

    private String cidade;

    public HospedagemDTO(Long id, String nome, String telefone1, String telefone2, String logradouro, String numero, String cidade) {
        this.id = id;
        this.nome = nome;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
    }
}