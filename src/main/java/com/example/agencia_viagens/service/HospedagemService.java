package com.example.agencia_viagens.service;

import com.example.agencia_viagens.dto.HospedagemDTO;
import com.example.agencia_viagens.model.Hospedagem;
import com.example.agencia_viagens.repository.HospedagemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HospedagemService {

    private final HospedagemRepository hospedagemRepository;

    public HospedagemDTO salvar(HospedagemDTO dto) {
        Hospedagem hospedagem = new Hospedagem();
        hospedagem.setNome(dto.nome());
        hospedagem.setEmail(dto.email());
        hospedagem.setEndereco(dto.endereco());

        hospedagem = hospedagemRepository.save(hospedagem);

        return new HospedagemDTO(hospedagem.getIdHospedagem(), hospedagem.getNome(), hospedagem.getEmail(), hospedagem.getEndereco(), null);
    }

    public HospedagemDTO buscarPorId(Long id) {
        Hospedagem hospedagem = hospedagemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hospedagem não encontrada"));

        return new HospedagemDTO(hospedagem.getIdHospedagem(), hospedagem.getNome(), hospedagem.getEmail(), hospedagem.getEndereco(), null);
    }

    public List<HospedagemDTO> listarTodos() {
        return hospedagemRepository.findAll().stream()
                .map(h -> new HospedagemDTO(h.getIdHospedagem(), h.getNome(), h.getEmail(), h.getEndereco(), h.obterDescricao()))
                .collect(Collectors.toList());
    }

    public HospedagemDTO atualizar(Long id, HospedagemDTO dto) {
        Hospedagem hospedagem = hospedagemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hospedagem não encontrada"));

        hospedagem.setNome(dto.nome());
        hospedagem.setEmail(dto.email());
        hospedagem.setEndereco(dto.endereco());

        hospedagem = hospedagemRepository.save(hospedagem);

        return new HospedagemDTO(hospedagem.getIdHospedagem(), hospedagem.getNome(), hospedagem.getEmail(), hospedagem.getEndereco(), null);
    }

    public void deletar(Long id) {
        if (!hospedagemRepository.existsById(id)) {
            throw new EntityNotFoundException("Hospedagem não encontrada");
        }
        hospedagemRepository.deleteById(id);
    }
}
