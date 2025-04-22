package com.example.agencia_viagens.controller;

import com.example.agencia_viagens.dto.HospedagemDTO;
import com.example.agencia_viagens.service.HospedagemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospedagens")
@RequiredArgsConstructor
public class HospedagemController {

    private final HospedagemService hospedagemService;

    @PostMapping
    public ResponseEntity<HospedagemDTO> criar(@Valid @RequestBody HospedagemDTO dto) {
        return ResponseEntity.ok(hospedagemService.salvar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospedagemDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(hospedagemService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<HospedagemDTO>> listarTodos() {
        return ResponseEntity.ok(hospedagemService.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HospedagemDTO> atualizar(@PathVariable Long id, @Valid @RequestBody HospedagemDTO dto) {
        return ResponseEntity.ok(hospedagemService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        hospedagemService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
