package com.example.agencia_viagens.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/erro")
@Slf4j
public class ErrorController {
    
    @GetMapping
    public String error() {
        log.info("Houve um errro!");
        return "error";
    }

}
