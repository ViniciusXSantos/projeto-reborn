package com.example.agencia_viagens.repository;

import com.example.agencia_viagens.model.Hospedagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HospedagemRepository extends JpaRepository<Hospedagem, Long> {
    boolean existsByEmail(String email);
    boolean existsByTelefone1OrTelefone2(String telefone1, String telefone2);
    boolean existsByLogradouroAndNumero(String logradouro, String numero);
}