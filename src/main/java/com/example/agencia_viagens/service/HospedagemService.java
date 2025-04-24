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

    public Hospedagem buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hospedagem não encontrada"));
    }

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

    // Novo método para listar todas as hospedagens
    public List<Hospedagem> listarTodas() {
        return repository.findAll(); // Usa o método padrão do JpaRepository
    }

    // Opcional: Método para converter Hospedagem em HospedagemDTO
    public List<HospedagemDTO> listarTodasDTO() {
        return repository.findAll().stream()
                .map(h -> new HospedagemDTO(
                        h.getId(),
                        h.getNome(),
                        h.getTelefone1(),
                        h.getTelefone2(),
                        h.getLogradouro(),
                        h.getNumero(),
                        h.getCidade()))
                .collect(Collectors.toList());
    }

    public void deletarHospedagem(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Hospedagem não encontrada com ID: " + id);
        }
        repository.deleteById(id);
    }

    public void editarHospedagem(Long id, HospedagemDTO dto) {
        Hospedagem hospedagem = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hospedagem não encontrada"));

        // Atualiza APENAS os campos permitidos (front-end)
        hospedagem.setNome(dto.getNome());
        hospedagem.setTelefone1(dto.getTelefone1());
        hospedagem.setTelefone2(dto.getTelefone2());
        hospedagem.setLogradouro(dto.getLogradouro());
        hospedagem.setNumero(dto.getNumero());
        hospedagem.setCidade(dto.getCidade());

        repository.save(hospedagem);
    }

}