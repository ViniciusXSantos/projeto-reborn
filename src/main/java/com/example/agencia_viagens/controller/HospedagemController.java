package com.example.agencia_viagens.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hospedagem")
public class HospedagemController {

    @GetMapping()
    public String cadastroHospedagem(){
        return "forms-hospedagem";
    }
}
