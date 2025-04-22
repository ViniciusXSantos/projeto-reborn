package com.example.agencia_viagens.controller;

import com.example.agencia_viagens.dto.EnderecoDTO;
import com.example.agencia_viagens.model.Endereco;
import com.example.agencia_viagens.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoDTO> criar(@RequestBody EnderecoDTO dto) {
        Endereco endereco = enderecoService.salvar(dto);
        return ResponseEntity.ok(new EnderecoDTO(endereco));
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> listarTodos() {
        List<EnderecoDTO> enderecos = enderecoService.buscarTodos()
                .stream()
                .map(EnderecoDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> buscarPorId(@PathVariable Long id) {
        Endereco endereco = enderecoService.buscarPorId(id);
        return ResponseEntity.ok(new EnderecoDTO(endereco));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> atualizar(@PathVariable Long id, @RequestBody EnderecoDTO dto) {
        Endereco endereco = enderecoService.atualizar(id, dto);
        return ResponseEntity.ok(new EnderecoDTO(endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        enderecoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
