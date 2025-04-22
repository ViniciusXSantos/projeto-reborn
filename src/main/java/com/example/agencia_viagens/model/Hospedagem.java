package com.example.agencia_viagens.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hospedagem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true, exclude = "endereco")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Hospedagem extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hospedagem", nullable = false)
    @EqualsAndHashCode.Include
    private Long idHospedagem;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
    private Endereco endereco;

    @Override
    public String obterDescricao() {
        return "Hospedagem ID: " + idHospedagem;
    }
}
