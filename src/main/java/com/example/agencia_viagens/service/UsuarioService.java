package com.example.agencia_viagens.service;

import java.util.List;



import com.example.agencia_viagens.dto.UsuarioDTO;


public interface UsuarioService {

  void save(UsuarioDTO dto);

  List<UsuarioDTO> findAll();

  void remove(Long userId);

  UsuarioDTO findById(Long userId);

}
