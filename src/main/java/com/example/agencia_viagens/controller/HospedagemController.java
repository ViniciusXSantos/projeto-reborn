package com.example.agencia_viagens.controller;

import com.example.agencia_viagens.model.Hospedagem;
import com.example.agencia_viagens.service.HospedagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hospedagens")
public class HospedagemController {

    @Autowired
    private HospedagemService hospedagemService;

    @GetMapping("/cadastro")
    public String mostrarFormulario() {
        return "forms-hospedagem";
    }

    @PostMapping("/cadastro")
    public String cadastrarHospedagem(
            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam String telefone1,
            @RequestParam String tipoTelefone1,
            @RequestParam(required = false) String telefone2,
            @RequestParam(required = false) String tipoTelefone2,
            @RequestParam String pais,
            @RequestParam String estado,
            @RequestParam String cidade,
            @RequestParam String bairro,
            @RequestParam String logradouro,
            @RequestParam String numero,
            @RequestParam(required = false) String complemento,
            Model model) {

        Hospedagem hospedagem = new Hospedagem();
        hospedagem.setNome(nome);
        hospedagem.setEmail(email);
        hospedagem.setTelefone1(telefone1);
        hospedagem.setTipoTelefone1(tipoTelefone1);
        hospedagem.setTelefone2(telefone2);
        hospedagem.setTipoTelefone2(tipoTelefone2);
        hospedagem.setPais(pais);
        hospedagem.setEstado(estado);
        hospedagem.setCidade(cidade);
        hospedagem.setBairro(bairro);
        hospedagem.setLogradouro(logradouro);
        hospedagem.setNumero(numero);
        hospedagem.setComplemento(complemento);

        try {
            hospedagemService.salvarHospedagem(hospedagem);
            return "redirect:/hospedagens/cadastro?sucesso";
        } catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
            return "forms-hospedagem";
        }
    }

    @GetMapping
    public String listarHospedagens(Model model) {
        return "exibicao-hospedagem";
    }

}

