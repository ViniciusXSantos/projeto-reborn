package com.example.agencia_viagens.repository;

import com.example.agencia_viagens.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}