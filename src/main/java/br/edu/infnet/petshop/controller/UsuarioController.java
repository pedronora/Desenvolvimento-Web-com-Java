package br.edu.infnet.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.petshop.model.domain.Usuario;
import br.edu.infnet.petshop.service.UsuarioService;

@Controller
public class UsuarioController {
    private String msg;
    private String alert;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/usuario")
    public String telaCadastro() {
        return "usuario/cadastro";
    }

    @GetMapping(value = "/usuario/lista")
    public String telaLista(Model model) {
        model.addAttribute("usuarios", usuarioService.getAll());
        model.addAttribute("mensagem", msg);
        model.addAttribute("alerta", alert);
        msg = null;

        return "usuario/lista";
    }

    @PostMapping(value = "/usuario/incluir")
    public String create(Usuario usuario) {
        usuarioService.create(usuario);
        msg = "A inclusão do usuário '" + usuario.getNome() + "' foi realizada com sucesso!";
        alert = "success";

        return "redirect:/login";
    }

    @GetMapping(value = "/usuario/{id}/detalhes")
    public String details(Model model, @PathVariable Integer id) {
        Usuario usuario = usuarioService.getById(id);
        model.addAttribute("usuario", usuario);
        return "usuario/detalhes";
    }

    @GetMapping(value = "/usuario/{id}/editar")
    public String update(Model model, @PathVariable Integer id) {
        Usuario usuario = usuarioService.getById(id);
        model.addAttribute("usuario", usuario);
        return "usuario/editar";
    }

    @PostMapping(value = "/usuario/editar")
    public String updated(Usuario usuario) {
        usuarioService.update(usuario);
        msg = "As informações do usuario '" + usuario.getNome() + "' foram atualizadas com sucesso!";
        alert = "success";

        return "redirect:/usuario/lista";
    }

    @GetMapping(value = "/usuario/{id}/excluir")
    public String delete(@PathVariable Integer id) {
        Usuario usuario = usuarioService.getById(id);
        usuarioService.delete(id);
        msg = "O usuaŕio '" + usuario.getNome() + "' foi excluído!";
        alert = "danger";

        return "redirect:/usuario/lista";
    }
}