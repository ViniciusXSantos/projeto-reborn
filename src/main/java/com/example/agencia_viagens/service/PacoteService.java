package com.example.agencia_viagens.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.agencia_viagens.dto.PacoteDTO;

@Repository
public interface PacoteService {

    /*public List<PacoteDTO> buscarTodos() {
        return List.of(new PacoteDTO()).stream().collect(Collectors.toList());
    }*/
    public List<PacoteDTO> buscarTodos();

    public void salvar(PacoteDTO pacoteDTO);

    public Object buscarPorId(Long id);
    
    PacoteDTO findOne(Long id);

    public void remove(Long id);
}
