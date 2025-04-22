package com.example.agencia_viagens.controller;

import com.example.agencia_viagens.dto.ClienteDTO;
import com.example.agencia_viagens.model.Cliente;
import com.example.agencia_viagens.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Página de listagem de clientes
    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        List<ClienteDTO> clientes = clienteService.buscarTodos();
        model.addAttribute("clientes", clientes);
        return "exibicao-usuario-cliente.jte";
    }

    // Página de cadastro de cliente
    @GetMapping("/clientes/novo")
    public String novoCliente() {
        return "cadastro-usuario-cliente.jte";
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody ClienteDTO dto) {
        Cliente cliente = clienteService.salvar(dto);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody ClienteDTO dto) {
        return ResponseEntity.ok(clienteService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
