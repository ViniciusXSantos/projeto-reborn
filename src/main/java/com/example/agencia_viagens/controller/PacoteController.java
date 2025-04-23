package com.example.agencia_viagens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.agencia_viagens.dto.PacoteDTO;
import com.example.agencia_viagens.service.PacoteService;

@Controller
@RequestMapping("/pacotes")
public class PacoteController {

    @Autowired
    private PacoteService pacoteService;

    // Página de listagem de pacotes
    @GetMapping()
    public String listarPacotes(Model model) {
        List<PacoteDTO> pacotes = pacoteService.buscarTodos();
        model.addAttribute("pacotes", pacotes);
        return "exibicao-pacote";
    }

    // Página de cadastro de pacotes
    @GetMapping("/novo")
    public String cadastroPacote(){
        return "forms-pacote";
    }
}
