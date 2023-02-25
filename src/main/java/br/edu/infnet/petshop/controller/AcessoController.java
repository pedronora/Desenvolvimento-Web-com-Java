package br.edu.infnet.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.petshop.model.domain.Usuario;
import br.edu.infnet.petshop.repository.AcessoRepository;

@Controller
public class AcessoController {
    @GetMapping(value = "/login")
    public String telaLogin() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(Model model, @RequestParam String email, @RequestParam String senha) {
        Usuario usuario = new Usuario(email, senha);

        if (AcessoRepository.autenticar(usuario)) {
            return "index";
        }

        model.addAttribute("mensagem", "As credenciais para o e-mail '" + email + "' estão incorretas.");
        return "login";
    }
}
