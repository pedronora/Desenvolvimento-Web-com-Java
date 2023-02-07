package br.edu.infnet.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.petshop.model.domain.Banho;

@Controller
public class BanhoController {
    @GetMapping(value = "/banho")
    public String telaCadastro() {
        return "banho/cadastro";
    }

    @PostMapping(value = "/banho/incluir")
    public String incluir(Banho banho) {
        System.out.println("Inclusão realizada com sucesso: " + banho);
        return "redirect:/";
    }
}
