package com.example.agencia_viagens.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cliente")
@ToString(callSuper = true, exclude = {"telefones", "enderecos"})
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Cliente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", nullable = false)
    @EqualsAndHashCode.Include
    private Long idCliente;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Telefone> telefones = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Endereco> enderecos = new ArrayList<>();

    @Override
    public String obterDescricao() {
        return "Cliente ID: " + idCliente;
    }

    public void adicionarTelefone(Telefone telefone) {
        if (telefone != null && !telefones.contains(telefone)) {
            telefone.setCliente(this);
            telefone.setUsuario(null);
            telefones.add(telefone);
        }
    }

    public void removerTelefone(Telefone telefone) {
        if (telefone != null) {
            telefones.remove(telefone);
            telefone.setCliente(null);
        }
    }

    public void adicionarEndereco(Endereco endereco) {
        if (endereco != null && !enderecos.contains(endereco)) {
            endereco.setCliente(this);
            enderecos.add(endereco);
        }
    }

    public void removerEndereco(Endereco endereco) {
        if (endereco != null) {
            enderecos.remove(endereco);
            endereco.setCliente(null);
        }
    }

    public Usuario orElseThrow(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'orElseThrow'");
    }
}