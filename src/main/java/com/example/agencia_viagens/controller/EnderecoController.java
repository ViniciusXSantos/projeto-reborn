package com.example.agencia_viagens.controller;

import com.example.agencia_viagens.dto.EnderecoDTO;
import com.example.agencia_viagens.model.Endereco;
import com.example.agencia_viagens.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> listarTodos() {
        return ResponseEntity.ok(enderecoService.listarTodos());
    }

    @PostMapping("/cliente/{clienteId}")
    public ResponseEntity<Endereco> salvar(@PathVariable Long clienteId, @RequestBody EnderecoDTO dto) {
        return ResponseEntity.ok(enderecoService.salvar(clienteId, dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizar(@PathVariable Long id, @RequestBody EnderecoDTO dto) {
        return ResponseEntity.ok(enderecoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        enderecoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
