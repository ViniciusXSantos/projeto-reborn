package com.example.agencia_viagens.controller;

import com.example.agencia_viagens.dto.TelefoneDTO;
import com.example.agencia_viagens.model.Telefone;
import com.example.agencia_viagens.service.TelefoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/telefones")
@RequiredArgsConstructor
public class TelefoneController {

    private final TelefoneService telefoneService;

    @GetMapping
    public ResponseEntity<List<Telefone>> listarTodos() {
        return ResponseEntity.ok(telefoneService.listarTodos());
    }

    @PostMapping("/cliente/{clienteId}")
    public ResponseEntity<Telefone> salvar(@PathVariable Long clienteId, @RequestBody TelefoneDTO dto) {
        return ResponseEntity.ok(telefoneService.salvar(clienteId, dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Telefone> atualizar(@PathVariable Long id, @RequestBody TelefoneDTO dto) {
        return ResponseEntity.ok(telefoneService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        telefoneService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}