package com.example.agencia_viagens.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "telefone")
@ToString(exclude = {"usuario", "cliente"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Telefone {

    public enum TipoTelefone {
        CELULAR, RESIDENCIAL, COMERCIAL, WHATSAPP
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefone")
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    @Pattern(regexp = "^\\(?(\\d{2})\\)?[\\s-]?(\\d{4,5})[\\s-]?(\\d{4})$", 
             message = "Formato inválido. Use (XX)XXXX-XXXX ou (XX)XXXXX-XXXX")
    @Column(nullable = false)
    private String numero;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTelefone tipo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Telefone(String numero, TipoTelefone tipo, Usuario usuario) {
        this.numero = numero;
        this.tipo = tipo;
        this.usuario = usuario;
    }

    public Telefone(String numero, TipoTelefone tipo, Cliente cliente) {
        this.numero = numero;
        this.tipo = tipo;
        this.cliente = cliente;
    }
}