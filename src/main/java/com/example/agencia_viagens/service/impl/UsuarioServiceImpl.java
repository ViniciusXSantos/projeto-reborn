package com.example.agencia_viagens.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.agencia_viagens.dto.UsuarioDTO;
import com.example.agencia_viagens.model.Usuario;
import com.example.agencia_viagens.repository.UsuarioRepository;
import com.example.agencia_viagens.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;


    @Override
    public void save(UsuarioDTO dto) {
        Usuario user = new Usuario(dto.getNome(), dto.getEmail(), dto.getSenha());
        user.setPapel("ADMIN");
        repository.save(user);
    }


    @Override
    public List<UsuarioDTO> findAll() {
        return repository.findAll().stream()
                .map(user -> new UsuarioDTO(user.getId(),user.getNome(), user.getEmail()))
                .toList();
    }


    @Override
    public void remove(Long userId) {
       repository.deleteById(userId);
    }


    @Override
    public UsuarioDTO findById(Long userId) {
        Usuario user = repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        return new UsuarioDTO(user.getId(), user.getNome(), user.getEmail());
    }
 
    
}
