package br.edu.infnet.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.petshop.model.domain.Servico;

@Controller
public class ServicoController {
    @GetMapping(value = "/servico")
    public String telaCadastro() {
        return "servico/cadastro";
    }

    @PostMapping(value = "/servico/incluir")
    public String incluir(Servico servico) {
        System.out.println("Inclusão realizada com sucesso: " + servico);
        return "redirect:/";
    }
}
