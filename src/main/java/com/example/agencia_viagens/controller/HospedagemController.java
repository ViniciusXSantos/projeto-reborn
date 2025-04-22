package com.example.agencia_viagens.controller;

import com.example.agencia_viagens.dto.HospedagemDTO;
import com.example.agencia_viagens.service.HospedagemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hospedagens")
@RequiredArgsConstructor
public class HospedagemController {

    private final HospedagemService hospedagemService;

    @GetMapping("/cadastro")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("hospedagem", new HospedagemDTO());
        return "forms-hospedagem";
    }

    @PostMapping("/cadastro")
    public String cadastrarHospedagem(@Valid @ModelAttribute HospedagemDTO hospedagemDTO) {
        hospedagemService.salvar(hospedagemDTO);
        return "redirect:/hospedagens";
    }

    @GetMapping
    public String listarHospedagens(Model model) {
        List<HospedagemDTO> hospedagens = hospedagemService.listarTodos();
        model.addAttribute("hospedagens", hospedagens);
        return "exibicao-hospedagem";
    }
}
