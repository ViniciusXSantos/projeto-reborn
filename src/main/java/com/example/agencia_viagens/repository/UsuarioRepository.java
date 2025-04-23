package com.example.agencia_viagens.repository;


import com.example.agencia_viagens.model.Usuario;
import com.example.agencia_viagens.repository.usuario.UsuarioRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioRepositoryQuery {

    boolean existsUsuarioByEmail(String email);
    Optional<Usuario> findByEmail(String email);

}