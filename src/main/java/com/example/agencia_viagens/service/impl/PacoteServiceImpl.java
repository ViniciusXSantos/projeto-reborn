package com.example.agencia_viagens.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.agencia_viagens.dto.PacoteDTO;
import com.example.agencia_viagens.mapping.PacoteMapper;
import com.example.agencia_viagens.model.Pacote;
import com.example.agencia_viagens.model.Usuario;
import com.example.agencia_viagens.repository.PacoteRepository;
import com.example.agencia_viagens.service.PacoteService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacoteServiceImpl implements PacoteService {

    // private final PacoteRepository pacoteRepository;
    private final PacoteRepository pacoteRepository;
   //  private final PacoteMapper pacoteMapper;

    @Override
    public List<PacoteDTO> buscarTodos() {
        List<Pacote> pacotes = pacoteRepository.findAll();
    
        List<PacoteDTO> pacoteDtos = pacotes.stream()
            .map(PacoteMapper::toDto)
            .collect(Collectors.toList());
    
        return pacoteDtos;
    }

    @Override
    public void salvar(PacoteDTO pacoteDTO) {

        Pacote pacote = pacoteDTO.toEntity();
        pacoteRepository.save(pacote);
 
    }

    @Override
    public Object buscarPorId(Long id) {
        Pacote pacote = pacoteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pacote não encontrado"));
        return PacoteMapper.toDto(pacote);
    }

    @Override
    public PacoteDTO findOne(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public void remove(Long id) {
        pacoteRepository.deleteById(id);
    }

}
