package com.example.agencia_viagens.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.agencia_viagens.model.Pacote;
import com.example.agencia_viagens.dto.PacoteDTO;

import com.example.agencia_viagens.repository.PacoteRepository;
import com.example.agencia_viagens.service.PacoteService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/pacotes")
@RequiredArgsConstructor
public class PacoteController {

    private final PacoteService pacoteService;
    private final PacoteRepository pacoteRepository;

    // Página de listagem de pacotes
    @GetMapping()
    public String listarPacotes(Model model) {
        List<PacoteDTO> pacotes = pacoteService.buscarTodos();
        model.addAttribute("pacotes", pacotes);
        return "exibicao-pacote";
    }

    @GetMapping("/pesquisa/{titulo}")
    public String buscarLikePacote(@PathVariable("titulo") String titulo, Model model) {
        List<PacoteDTO> pacotes = pacoteService.buscarTodos();
        model.addAttribute("pacotes", pacotes);
        return "exibicao-pacote";
    }

    // Página de cadastro de pacotes
    @GetMapping("/novo")
    public String cadastroPacote(){
        return "forms-pacote";
    }

    // Processa formulário de cadastro
    @PostMapping("/save")
    public String cadastrarCliente(PacoteDTO pacoteDTO, Model model) {
        try {
            pacoteService.salvar(pacoteDTO);
            return "redirect:/pacotes?sucesso";
        } catch (RuntimeException e) {
            model.addAttribute("erro", e.getMessage());
            return "forms-pacote";
        }
    }

    // Exibe formulário de edição
    @GetMapping("/edit/{id}")
    public ModelAndView buscarParaEditar(@PathVariable("id") Long id) {
        var model = new ModelAndView();
        model.setViewName("forms-pacote");
        model.addObject("pacotes", pacoteService.buscarPorId(id));
        return model;
    }

    // Processa atualização
    @PostMapping("/edit/{id}")
    public String atualizarCliente(@PathVariable Long id, PacoteDTO pacoteDTO, Model model) {
        Pacote original = pacoteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pacote não encontrado"));
        
        // Copia os campos compatíveis
        BeanUtils.copyProperties(pacoteDTO, original, "idPacote", "dataPartida", "dataChegada");

        // Converte e seta manualmente as datas
        if (pacoteDTO.getDataPartida() != null && !pacoteDTO.getDataPartida().isEmpty()) {
            original.setDataPartida(LocalDate.parse(pacoteDTO.getDataPartida()));
        }
        if (pacoteDTO.getDataChegada() != null && !pacoteDTO.getDataChegada().isEmpty()) {
            original.setDataChegada(LocalDate.parse(pacoteDTO.getDataChegada()));
        }

        pacoteRepository.save(original);
        return "redirect:/pacotes?sucesso";
    }

    @GetMapping("/remover/{id}")
    public String remove(@PathVariable Long id) {
        pacoteService.remove(id);
        return "redirect:/pacotes";
    }

}





