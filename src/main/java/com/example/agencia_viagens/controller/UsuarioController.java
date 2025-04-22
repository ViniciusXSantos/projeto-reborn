package com.example.agencia_viagens.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.agencia_viagens.dto.UsuarioDTO;
import com.example.agencia_viagens.service.UsuarioService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping()
    public String gerenciamentoUser(UsuarioDTO user,Model model){
        List<UsuarioDTO> usuarios= usuarioService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("usuarios", usuarios);
        return "gerenciamento-usuario";
    }

    @GetMapping("/cadastro")
    public String cadastroUser(){
        return "cadastro-usuario";
    }


    @PostMapping("/save")
    public String userSave(UsuarioDTO dto) {
        usuarioService.save(dto);
        return "redirect:/user";
    }
    
    @GetMapping("/remover/{userId}")
    public String remove(@PathVariable Long userId) {
        usuarioService.remove(userId);
        return "redirect:/user";
    }

    @GetMapping("/edit/{userId}")
    public String editar(@PathVariable Long userId, Model model) {
        model.addAttribute("user",  usuarioService.findById(userId)); 
        return "/user/cadastro";
    }
    
}
