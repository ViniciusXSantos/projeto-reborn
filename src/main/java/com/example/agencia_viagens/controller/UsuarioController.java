package com.example.agencia_viagens.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.agencia_viagens.dto.UsuarioDTO;
import com.example.agencia_viagens.model.Usuario;
import com.example.agencia_viagens.repository.UsuarioRepository;
import com.example.agencia_viagens.service.UsuarioService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsuarioController {

    private final PasswordEncoder encoder;
    private final UsuarioService usuarioService;

     private final UsuarioRepository repository;

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
        dto.setSenha(encoder.encode(dto.getSenha()));
        usuarioService.save(dto);
        return "redirect:/user";
    }
    
    @GetMapping("/remover/{userId}")
    public String remove(@PathVariable Long userId) {
        usuarioService.remove(userId);
        return "redirect:/user";
    }

    // Busca apenas pelo ID    
    /*@GetMapping("/edit/{userId}")
    public String editar(@PathVariable Long userId, Model model) {
        model.addAttribute("user",  usuarioService.findById(userId)); 
        return "/user/cadastro";
    }*/
    @GetMapping("/edit/{userId}")
    public ModelAndView buscarParaEditar(@PathVariable("userId") Long id) {
        var model = new ModelAndView();
        model.setViewName("cadastro-usuario");
        model.addObject("user", usuarioService.findById(id));
        return model;
    }

    // Atualiza os dados pelo ID
    @PostMapping("/edit/{userId}")
    public String editarSave(@PathVariable("userId") Long userId, UsuarioDTO dto) {
        Usuario original = repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

                if (!dto.getSenha().isBlank()) {
                    dto.setSenha(encoder.encode(dto.getSenha()));
                }else{
                    // throw new Exception(null);
                }
        
        BeanUtils.copyProperties(dto, original, "id");
        repository.save(original);
        return "redirect:/user";
    }
    
    /*@PostMapping("/edit/{userId}")
    public String editarSave(@PathVariable("userId") Long userId, UsuarioDTO dto) {
        UsuarioDTO original = usuarioService.findById(dto.getId());
        
        if (!dto.getSenha().isBlank()) {
            dto.setSenha(encoder.encode(dto.getSenha()));
        } else {
            dto.setSenha(original.getSenha()); // mantém senha anterior
        }

        usuarioService.save(dto);
        return "redirect:/user";
    }*/

    @GetMapping("/create")
    public ModelAndView formCreate() {
        var model = new ModelAndView();
        model.setViewName("cadastro-usuario");
        model.addObject("user", new UsuarioDTO());
        return model;
    }
    
}
