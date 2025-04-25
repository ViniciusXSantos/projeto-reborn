package com.example.agencia_viagens.controller;

import com.example.agencia_viagens.dto.ClienteDTO;
import com.example.agencia_viagens.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Lista todos os clientes
    @GetMapping
    public String listarClientes(Model model) {
        List<ClienteDTO> clientes = clienteService.buscarTodos();
        model.addAttribute("clientes", clientes);
        return "exibicao-usuario-cliente";
    }

    // Exibe formulário de cadastro
    @GetMapping("/novo")
    public String novoCliente() {
        return "cadastro-usuarios-cliente";
    }

    // Processa formulário de cadastro
    @PostMapping("/novo")
    public String cadastrarCliente(ClienteDTO clienteDTO, Model model) {
        try {
            clienteService.salvar(clienteDTO);
            return "redirect:/clientes?sucesso";
        } catch (RuntimeException e) {
            model.addAttribute("erro", e.getMessage());
            return "cadastro-usuarios-cliente";
        }
    }

    // Exibe formulário de edição
    @GetMapping("/edit/{id}")
    public ModelAndView editarCliente(@PathVariable Long id) {
        ModelAndView model = new ModelAndView("cadastro-usuarios-cliente");
        model.addObject("cliente", clienteService.buscarPorId(id));
        return model;
    }

    // Processa atualização
    @PostMapping("/edit/{id}")
    public String atualizarCliente(@PathVariable Long id, ClienteDTO clienteDTO, Model model) {
        try {
            clienteDTO.setId(id);
            clienteService.salvar(clienteDTO);
            return "redirect:/clientes?sucesso";
        } catch (RuntimeException e) {
            model.addAttribute("erro", e.getMessage());
            model.addAttribute("cliente", clienteDTO);
            return "cadastro-usuarios-cliente";
        }
    }
}