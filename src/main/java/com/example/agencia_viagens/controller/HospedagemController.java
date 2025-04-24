package com.example.agencia_viagens.controller;

import com.example.agencia_viagens.dto.HospedagemDTO;
import com.example.agencia_viagens.model.Hospedagem;
import com.example.agencia_viagens.service.HospedagemService;
import com.example.agencia_viagens.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

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
        List<Hospedagem> hospedagens = hospedagemService.listarTodas(); // Busca do banco
        List<HospedagemDTO> hospedagensDTO = hospedagens.stream()
                .map(h -> new HospedagemDTO(
                        h.getId(),
                        h.getNome(),
                        h.getTelefone1(),
                        h.getTelefone2(),
                        h.getLogradouro(),
                        h.getNumero(),
                        h.getCidade()))
                .collect(Collectors.toList()); // Converte para DTO

        model.addAttribute("hospedagens", hospedagensDTO); // Envia para a view
        return "exibicao-hospedagem"; // Nome do template (sem .jte)
    }

    @GetMapping("/deletar/{id}")
    public String deletarHospedagem(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            hospedagemService.deletarHospedagem(id);
            redirectAttributes.addFlashAttribute("sucesso", "Hospedagem deletada com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao deletar: " + e.getMessage());
        }
        return "redirect:/hospedagens";
    }

    // Mostra o formulário de edição
    @GetMapping("/editar/{id}")
    public String mostrarFormEdicao(@PathVariable Long id, Model model) {
        Hospedagem hospedagem = hospedagemService.buscarPorId(id);
        model.addAttribute("hospedagem", hospedagem);
        return "editar-hospedagem"; // Nome do seu template JTE
    }

    // Processa a edição
    @PostMapping("/editar/{id}")
    public String editarHospedagem(
            @PathVariable Long id,
            @ModelAttribute HospedagemDTO dto,
            RedirectAttributes redirectAttributes) {

        try {
            hospedagemService.editarHospedagem(id, dto);
            redirectAttributes.addFlashAttribute("sucesso", "Hospedagem atualizada!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao editar: " + e.getMessage());
        }
        return "redirect:/hospedagens";
    }

}

