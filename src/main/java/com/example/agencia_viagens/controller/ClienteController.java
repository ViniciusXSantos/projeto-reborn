package com.example.agencia_viagens.controller;

import com.example.agencia_viagens.dto.ClienteDTO;
import com.example.agencia_viagens.dto.UsuarioDTO;
import com.example.agencia_viagens.model.Cliente;
import com.example.agencia_viagens.model.Usuario;
import com.example.agencia_viagens.service.ClienteService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public String novoCliente(ClienteDTO dto) {
        return "cadastro-usuarios-cliente";
    }

    // Busca apenas pelo ID
    @GetMapping("/edit/{id}")
    public ModelAndView buscarParaEditar(@PathVariable("id") Long id) {
        var model = new ModelAndView();
        model.setViewName("cadastro-usuarios-cliente");
        model.addObject("clientes", clienteService.buscarPorId(id));
        return model;
    }

    // Atualiza os dados pelo ID
    @PostMapping("/edit/{id}")
    public String editarSave(@PathVariable("id") Long userId, ClienteDTO dto) {
        clienteService.salvar(dto);
        return "redirect:/clientes";
    }
  
}
