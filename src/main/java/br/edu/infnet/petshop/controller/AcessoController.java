package br.edu.infnet.petshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.petshop.model.domain.Usuario;
import br.edu.infnet.petshop.repository.AcessoRepository;

@Controller
@SessionAttributes("user")
public class AcessoController {
    @GetMapping(value = "/login")
    public String telaLogin() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(Model model, @RequestParam String email, @RequestParam String senha) {
        Usuario usuario = new Usuario(email, senha);

        Usuario usuarioAutenticado = AcessoRepository.autenticar(usuario);

        if (usuarioAutenticado != null) {
            model.addAttribute("user", usuarioAutenticado);
            return "redirect:/home";
        }

        model.addAttribute("mensagem", "As credenciais para o e-mail '" + email + "' estão incorretas.");
        return  telaLogin();
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session, SessionStatus status) {
        status.setComplete();
        session.removeAttribute("user");
        return "redirect:/";
    }
}
