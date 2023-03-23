package br.edu.infnet.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.petshop.model.domain.Atendimento;
import br.edu.infnet.petshop.model.domain.Usuario;
import br.edu.infnet.petshop.service.AtendimentoService;

@Controller
public class AtendimentoController {
    private String msg;
    private String alert;

    @Autowired
    AtendimentoService atendimentoService;

    @GetMapping(value = "/atendimento/cadastro")
    public String telaCadastro() {
        return "/atendimento/cadastro";
    }

    @GetMapping(value = "/atendimento")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("atendimentos", atendimentoService.getAllByUsuario(usuario.getId()));
        model.addAttribute("mensagem", msg);
        model.addAttribute("alerta", alert);
        msg = null;

        return "/atendimento/lista";
    }

    @PostMapping(value = "/atendimento/incluir")
    public String incluir(Atendimento atendimento, @SessionAttribute("user") Usuario usuario) {
        atendimento.setUsuario(usuario);
        atendimentoService.create(atendimento);
        msg = "A inclusão do atendimento '" + atendimento.getDescricao() + "' foi realizada com sucesso!";
        alert = "success";

        return "redirect:/atendimento";
    }

    @GetMapping(value = "/atendimento/{id}/detalhes")
    public String detalhes(Model model, @PathVariable Integer id) {
        Atendimento atendimento = atendimentoService.getById(id);
        model.addAttribute("atendimento", atendimento);
        return "/atendimento/detalhes";
    }

    @GetMapping(value = "/atendimento/{id}/editar")
    public String editar(Model model, @PathVariable Integer id) {
        Atendimento atendimento = atendimentoService.getById(id);
        model.addAttribute("atendimento", atendimento);
        return "/atendimento/editar";
    }

    @PostMapping(value = "/atendimento/editar")
    public String editado(Atendimento atendimento, @SessionAttribute("user") Usuario usuario) {
        atendimento.setUsuario(usuario);
        atendimentoService.update(atendimento);
        msg = "As informações do '" + atendimento.getDescricao() + "' foram atualizadas com sucesso!";
        alert = "success";

        return "redirect:/atendimento";
    }

    @GetMapping(value = "/atendimento/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        Atendimento atendimento = atendimentoService.getById(id);
        atendimentoService.delete(id);
        msg = "O '" + atendimento.getDescricao() + "' foi excluído!";
        alert = "danger";

        return "redirect:/atendimento";
    }
}
