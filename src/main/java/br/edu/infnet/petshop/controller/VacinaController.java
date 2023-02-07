package br.edu.infnet.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.petshop.model.domain.Vacina;

@Controller
public class VacinaController {
    @GetMapping(value = "/vacina")
    public String telaCadastro() {
        return "vacina/cadastro";
    }

    @PostMapping(value = "/vacina/incluir")
    public String incluir(Vacina vacina) {
        System.out.println("Inclusão realizada com sucesso: " + vacina);
        return "redirect:/";
    }
}
