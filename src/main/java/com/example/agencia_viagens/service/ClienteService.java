package com.example.agencia_viagens.service;

import com.example.agencia_viagens.dto.ClienteDTO;
import com.example.agencia_viagens.model.Cliente;
import com.example.agencia_viagens.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteDTO> buscarTodos() {
        return clienteRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return convertToDTO(cliente);
    }

    public void salvar(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();

        if (clienteDTO.getId() != null) {
            cliente = clienteRepository.findById(clienteDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        }

        // Valida e-mail único apenas para novos clientes
        if (clienteDTO.getId() == null &&
                clienteRepository.existsByEmail(clienteDTO.getEmail())) {
            throw new RuntimeException("Já existe um cliente com este e-mail");
        }

        BeanUtils.copyProperties(clienteDTO, cliente);
        clienteRepository.save(cliente);
    }

    private ClienteDTO convertToDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        BeanUtils.copyProperties(cliente, dto);
        return dto;
    }

    public void deletar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }

}