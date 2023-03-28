package br.edu.infnet.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.petshop.service.EnderecoService;

@Controller
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;
    
    @PostMapping(value = "/{form}/cep")
    public String buscaCEP(Model model, @RequestParam String cep, @PathVariable String form) {

        model.addAttribute("endereco", enderecoService.buscaCEP(cep));
        
        return form + "/cadastro";
    }
}
