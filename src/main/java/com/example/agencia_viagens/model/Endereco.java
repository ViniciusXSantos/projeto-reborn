package com.example.agencia_viagens.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "endereco")
@ToString(exclude = "cliente")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    @EqualsAndHashCode.Include
    private Long idEndereco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @NotNull
    @Pattern(regexp = "^[0-9]{5}-[0-9]{3}$", message = "CEP deve estar no formato XXXXX-XXX")
    private String cep;

    @NotNull
    @Pattern(regexp = "^[A-Z]{2}$", message = "Estado deve ser sigla com 2 letras maiúsculas")
    private String estado;

    @NotNull
    @Size(min = 2, max = 255)
    private String cidade;

    @NotNull
    @Size(min = 2, max = 255)
    private String bairro;

    @NotNull
    @Size(min = 2, max = 255)
    private String logradouro;

    @NotNull
    private String numero;

    @Size(max = 255)
    private String complemento;
}