package com.example.agencia_viagens.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.agencia_viagens.dto.PacoteDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacoteService {

    public List<PacoteDTO> buscarTodos() {
        return List.of(new PacoteDTO()).stream().collect(Collectors.toList());
    }
    
}
