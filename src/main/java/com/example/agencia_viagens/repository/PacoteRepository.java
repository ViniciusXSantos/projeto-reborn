package com.example.agencia_viagens.repository;

import org.springframework.stereotype.Repository;
import com.example.agencia_viagens.model.Pacote;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote, Long>{

}
