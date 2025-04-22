package com.example.agencia_viagens.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {

    private Long idEndereco;

    @NotNull
    @Pattern(regexp = "^[0-9]{5}-[0-9]{3}$", message = "CEP deve estar no formato XXXXX-XXX")
    private String cep;

    @NotNull
    @Size(min = 3, max = 20)
    private String estado;

    @NotNull
    @Size(min = 3, max = 255)
    private String cidade;

    @NotNull
    @Size(min = 3, max = 255)
    private String bairro;

    @NotNull
    @Size(min = 3, max = 255)
    private String logradouro;

    @NotNull
    private String numero;

    private String complemento;
}
