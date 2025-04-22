package com.example.agencia_viagens.service;

import com.example.agencia_viagens.dto.ClienteDTO;
import com.example.agencia_viagens.dto.EnderecoDTO;
import com.example.agencia_viagens.dto.TelefoneDTO;
import com.example.agencia_viagens.model.Cliente;
import com.example.agencia_viagens.model.Endereco;
import com.example.agencia_viagens.model.Telefone;
import com.example.agencia_viagens.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente salvar(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());

        if (dto.getTelefones() != null) {
            for (TelefoneDTO telDto : dto.getTelefones()) {
                Telefone telefone = new Telefone();
                telefone.setNumero(telDto.getNumero());
                telefone.setTipo(Telefone.TipoTelefone.valueOf(telDto.getTipo().toUpperCase()));
                cliente.adicionarTelefone(telefone);
            }
        }

        if (dto.getEnderecos() != null) {
            for (EnderecoDTO endDto : dto.getEnderecos()) {
                Endereco endereco = new Endereco();
                endereco.setCep(endDto.getCep());
                endereco.setEstado(endDto.getEstado());
                endereco.setCidade(endDto.getCidade());
                endereco.setBairro(endDto.getBairro());
                endereco.setLogradouro(endDto.getLogradouro());
                endereco.setNumero(endDto.getNumero());
                endereco.setComplemento(endDto.getComplemento());
                cliente.adicionarEndereco(endereco);
            }
        }

        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
    }

    public Cliente atualizar(Long id, ClienteDTO dto) {
        Cliente cliente = buscarPorId(id);
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        // lógica para atualizar telefones/endereços pode ser adicionada aqui
        return clienteRepository.save(cliente);
    }

    public void deletar(Long id) {
        Cliente cliente = buscarPorId(id);
        clienteRepository.delete(cliente);
    }

    public List<ClienteDTO> buscarTodos() {
        // Mock implementation, replace with actual logic to fetch all clients
        return List.of(new ClienteDTO()).stream().collect(Collectors.toList());
    }
}
