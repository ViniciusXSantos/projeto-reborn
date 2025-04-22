package com.example.agencia_viagens.dto;

import com.example.agencia_viagens.model.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record HospedagemDTO(

    Long idHospedagem,

    @NotNull
    @Size(min = 3, max = 255)
    String nome,

    @NotNull
    @Email
    @Size(max = 255)
    String email,

    @NotNull
    Endereco endereco,

    String descricao // Campo adicional para exibição
) {

    public HospedagemDTO() {
        this(null, null, null, null, null);
    }}
