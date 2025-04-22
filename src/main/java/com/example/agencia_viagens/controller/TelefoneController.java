package com.example.agencia_viagens.controller;

import com.example.agencia_viagens.dto.TelefoneDTO;
import com.example.agencia_viagens.model.Telefone;
import com.example.agencia_viagens.service.TelefoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/telefones")
@RequiredArgsConstructor
public class TelefoneController {

    private final TelefoneService telefoneService;

    @PostMapping
    public ResponseEntity<TelefoneDTO> criar(@RequestBody TelefoneDTO dto) {
        Telefone telefone = telefoneService.salvar(dto);
        return ResponseEntity.ok(new TelefoneDTO(telefone));
    }

    @GetMapping
    public ResponseEntity<List<TelefoneDTO>> listarTodos() {
        List<TelefoneDTO> telefones = telefoneService.buscarTodos()
                .stream()
                .map(TelefoneDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(telefones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelefoneDTO> buscarPorId(@PathVariable Long id) {
        Telefone telefone = telefoneService.buscarPorId(id);
        return ResponseEntity.ok(new TelefoneDTO(telefone));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelefoneDTO> atualizar(@PathVariable Long id, @RequestBody TelefoneDTO dto) {
        Telefone telefone = telefoneService.atualizar(id, dto);
        return ResponseEntity.ok(new TelefoneDTO(telefone));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        telefoneService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
