package com.example.agencia_viagens.service;

import com.example.agencia_viagens.dto.PacoteDTO;
import com.example.agencia_viagens.model.Pacote;
import com.example.agencia_viagens.repository.PacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PacoteService {

    @Autowired
    private PacoteRepository pacoteRepository;



    public List<PacoteDTO> buscarTodos() {
        return List.of(new PacoteDTO()).stream().collect(Collectors.toList());
    }
    
}
