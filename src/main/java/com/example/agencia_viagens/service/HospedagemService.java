package com.example.agencia_viagens.service;
import com.example.agencia_viagens.dto.HospedagemDTO;
import com.example.agencia_viagens.model.Hospedagem;
import com.example.agencia_viagens.repository.HospedagemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class HospedagemService {

    @Autowired
    private HospedagemRepository repository;

    public void salvarHospedagem(Hospedagem hospedagem) {
        // Validações
        if (repository.existsByEmail(hospedagem.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        if (repository.existsByTelefone1OrTelefone2(hospedagem.getTelefone1(), hospedagem.getTelefone2())) {
            throw new IllegalArgumentException("Telefone já cadastrado");
        }

        if (repository.existsByLogradouroAndNumero(hospedagem.getLogradouro(), hospedagem.getNumero())) {
            throw new IllegalArgumentException("Endereço já cadastrado");
        }

        repository.save(hospedagem);
    }
}