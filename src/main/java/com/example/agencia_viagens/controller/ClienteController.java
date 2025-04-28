package com.example.agencia_viagens.controller;

import com.example.agencia_viagens.dto.ClienteDTO;
import com.example.agencia_viagens.dto.PacoteDTO;
import com.example.agencia_viagens.model.Pacote;
import com.example.agencia_viagens.service.ClienteService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import com.example.agencia_viagens.model.Cliente;
import com.example.agencia_viagens.repository.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

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
    public ModelAndView buscarParaEditar(@PathVariable("id") Long id) {
        var model = new ModelAndView();
        model.setViewName("cadastro-usuarios-cliente");
        model.addObject("cli", clienteService.buscarPorId(id));
        return model;
    }

    // Processa atualização
    @PostMapping("/edit/{id}")
    public String atualizarCliente(@PathVariable Long id, ClienteDTO clienteDTO, Model model) {
        Cliente original = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        BeanUtils.copyProperties(clienteDTO, original, "id");
        clienteRepository.save(original);
        return "redirect:/clientes?sucesso";
    }

    // Deleta um cliente
    @GetMapping("/delete/{id}")
    public String deletarCliente(@PathVariable Long id) {
        clienteService.deletar(id);
        return "redirect:/clientes";
    }

}