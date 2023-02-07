package br.edu.infnet.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.petshop.model.domain.Consulta;

@Controller
public class ConsultaController {
    @GetMapping(value = "/consulta")
    public String telaCadastro() {
        return "consulta/cadastro";
    }

    @PostMapping(value = "/consulta/incluir")
    public String incluir(Consulta consulta) {
        System.out.println("Inclusão realizada com sucesso: " + consulta);
        return "redirect:/";
    }
}
