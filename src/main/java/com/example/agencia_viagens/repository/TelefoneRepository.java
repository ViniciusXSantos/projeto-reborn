package com.example.agencia_viagens.repository;


import com.example.agencia_viagens.model.Telefone;
import com.example.agencia_viagens.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

    /**
     * Retorna a lista de telefones de um usuário específico.
     */
    List<Telefone> findByUsuario(Usuario usuario);

    /**
     * Remove todos os telefones associados a um usuário.
     */
    @Transactional
    void deleteByUsuario(Usuario usuario);
}
