package com.example.agencia_viagens.repository;

import com.example.agencia_viagens.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}