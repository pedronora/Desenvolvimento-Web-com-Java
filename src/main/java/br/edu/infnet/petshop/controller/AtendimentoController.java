package br.edu.infnet.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.petshop.model.domain.Atendimento;
import br.edu.infnet.petshop.repository.AtendimentoRepository;

@Controller
public class AtendimentoController {
    private String msg;
    private String alert;

    @GetMapping(value = "/atendimento/cadastro")
    public String telaCadastro() {
        return "/atendimento/cadastro";
    }

    @GetMapping(value = "/atendimento")
    public String telaLista(Model model) {
        model.addAttribute("atendimentos", AtendimentoRepository.obterLista());
        model.addAttribute("mensagem", msg);
        model.addAttribute("alerta", alert);
        msg = null;

        return "/atendimento/lista";
    }

    @PostMapping(value = "/atendimento/incluir")
    public String incluir(Atendimento atendimento) {
        AtendimentoRepository.create(atendimento);
        msg = "A inclusão do atendimento '" + atendimento + "' foi realizada com sucesso!";
        alert = "success";

        return "redirect:/atendimento";
    }

    @GetMapping(value = "/atendimento/{id}/detalhes")
    public String detalhes(Model model, @PathVariable Integer id) {
        Atendimento atendimento = AtendimentoRepository.getById(id);
        model.addAttribute("atendimento", atendimento);
        return "/atendimento/detalhes";
    }

    @GetMapping(value = "/atendimento/{id}/editar")
    public String editar(Model model, @PathVariable Integer id) {
        Atendimento atendimento = AtendimentoRepository.getById(id);
        model.addAttribute("atendimento", atendimento);
        return "/atendimento/editar";
    }

    @PostMapping(value = "/atendimento/editar")
    public String editado(Atendimento atendimento) {
        AtendimentoRepository.editar(atendimento);
        msg = "As informações do '" + atendimento + "' foram atualizadas com sucesso!";
        alert = "success";

        return "redirect:/atendimento";
    }

    @GetMapping(value = "/atendimento/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        Atendimento atendimento = AtendimentoRepository.delete(id);
        msg = "O '" + atendimento + "' foi excluído!";
        alert = "danger";

        return "redirect:/atendimento";
    }
}
