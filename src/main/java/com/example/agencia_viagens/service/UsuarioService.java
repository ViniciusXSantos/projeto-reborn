package com.example.agencia_viagens.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.agencia_viagens.dto.UsuarioDTO;

@Repository
public interface UsuarioService {

  void save(UsuarioDTO dto);

  List<UsuarioDTO> findAll();

  void remove(Long userId);

  UsuarioDTO findById(Long userId);

}
