package com.example.agencia_viagens.service;

import com.example.agencia_viagens.dto.TelefoneDTO;
import com.example.agencia_viagens.model.Cliente;
import com.example.agencia_viagens.model.Telefone;
import com.example.agencia_viagens.repository.ClienteRepository;
import com.example.agencia_viagens.repository.TelefoneRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TelefoneService {

    private final TelefoneRepository telefoneRepository;
    private final ClienteRepository clienteRepository;

    public List<Telefone> listarTodos() {
        return telefoneRepository.findAll();
    }

    public Telefone salvar(Long clienteId, TelefoneDTO dto) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        Telefone telefone = new Telefone();
        telefone.setNumero(dto.getNumero());
        telefone.setTipo(Telefone.TipoTelefone.valueOf(dto.getTipo()));
        telefone.setCliente(cliente);

        return telefoneRepository.save(telefone);
    }

    public void deletar(Long id) {
        telefoneRepository.deleteById(id);
    }

    public Telefone atualizar(Long id, TelefoneDTO dto) {
        Telefone telefone = telefoneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Telefone não encontrado"));

        telefone.setNumero(dto.getNumero());
        telefone.setTipo(Telefone.TipoTelefone.valueOf(dto.getTipo()));

        return telefoneRepository.save(telefone);
    }
}
