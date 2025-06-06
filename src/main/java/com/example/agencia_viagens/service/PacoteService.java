package com.example.agencia_viagens.service;

import com.example.agencia_viagens.dto.PacoteDTO;

import java.util.List;


public interface PacoteService {

    public List<PacoteDTO> buscarTodos();

    public void salvar(PacoteDTO pacoteDTO);

    public Object buscarPorId(Long id);

    public void remove(Long id);
}
