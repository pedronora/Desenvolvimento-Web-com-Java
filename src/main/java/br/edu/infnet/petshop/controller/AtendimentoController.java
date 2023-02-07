package br.edu.infnet.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.petshop.model.domain.Atendimento;

@Controller
public class AtendimentoController {
    @GetMapping(value = "/atendimento")
    public String telaCadastro() {
        return "atendimento/cadastro";
    }

    @PostMapping(value = "/atendimento/incluir")
    public String incluir(Atendimento atendimento) {
        System.out.println("Inclusão realizada com sucesso: " + atendimento);
        return "redirect:/";
    }
}
