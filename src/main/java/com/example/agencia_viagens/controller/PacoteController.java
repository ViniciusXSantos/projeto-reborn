package com.example.agencia_viagens.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pacote")
public class PacoteController {

    @GetMapping()
    public String cadastroPacote(){
        return "forms-pacote";
    }
}
