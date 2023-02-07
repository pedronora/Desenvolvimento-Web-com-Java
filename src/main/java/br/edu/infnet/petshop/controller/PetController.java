package br.edu.infnet.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.petshop.model.domain.Pet;

@Controller
public class PetController {
    @GetMapping(value = "/pet")
    public String telaCadastro() {
        return "pet/cadastro";
    }

    @PostMapping(value = "/pet/incluir")
    public String incluir(Pet pet) {
        System.out.println("Inclusão realizada com sucesso: " + pet);
        return "redirect:/";
    }
}
