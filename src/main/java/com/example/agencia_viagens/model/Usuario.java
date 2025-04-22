package com.example.agencia_viagens.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "usuarios")
public class Usuario extends Pessoa {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo;

    @OneToMany(mappedBy = "usuario", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones;

    @Override
    public String obterDescricao() {
        return String.format("ID: %d, Usuário: %s, Email: %s, Ativo: %s",
                this.getIdUsuario(), super.getNome(), super.getEmail(), this.getAtivo() ? "Ativo" : "Inativo");
    }

}
