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

@RequestMapping("/clientes")
@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Página de listagem de clientes
    @GetMapping()
    public String listarClientes(Model model) {
        List<ClienteDTO> clientes = clienteService.buscarTodos();
        model.addAttribute("clientes", clientes);
        return "exibicao-usuario-cliente";
    }

    // Página de cadastro de cliente
    @GetMapping("/novo")
    public String novoCliente() {
        return "cadastro-usuarios-cliente";
    }

  
}
