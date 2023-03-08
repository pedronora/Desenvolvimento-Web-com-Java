package br.edu.infnet.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.petshop.model.domain.Vacina;
import br.edu.infnet.petshop.service.VacinaService;

@Controller
public class VacinaController {
    private String msg;
    private String alert;

    @Autowired
    VacinaService vacinaService;

    @GetMapping(value = "/servicos/vacina/cadastro")
    public String telaCadastro() {
        return "servicos/vacina/cadastro";
    }

    @GetMapping(value = "/servicos/vacina")
    public String telaLista(Model model) {
        model.addAttribute("vacinas", vacinaService.getAll());
        model.addAttribute("mensagem", msg);
        model.addAttribute("alerta", alert);
        msg = null;

        return "servicos/vacina/lista";
    }

    @PostMapping(value = "/servicos/vacina/incluir")
    public String create(Vacina vacina) {
        vacinaService.create(vacina);
        msg = "A inclusão do serviço '" + vacina.getNome() + "' foi realizada com sucesso!";
        alert = "success";

        return "redirect:/servicos/vacina";
    }

    @GetMapping(value = "/servicos/vacina/{id}/detalhes")
    public String details(Model model, @PathVariable Integer id) {
        Vacina vacina = vacinaService.getById(id);
        model.addAttribute("vacina", vacina);
        return "servicos/vacina/detalhes";
    }

    @GetMapping(value = "/servicos/vacina/{id}/editar")
    public String update(Model model, @PathVariable Integer id) {
        Vacina vacina = vacinaService.getById(id);
        model.addAttribute("vacina", vacina);
        return "servicos/vacina/editar";
    }

    @PostMapping(value = "/servicos/vacina/editar")
    public String updated(Vacina vacina) {
        vacinaService.update(vacina);
        msg = "As informações do serviço '" + vacina.getNome() + "' foram atualizadas com sucesso!";
        alert = "success";

        return "redirect:/servicos/vacina";
    }

    @GetMapping(value = "/servicos/vacina/{id}/excluir")
    public String delete(@PathVariable Integer id) {
        Vacina vacina = vacinaService.delete(id);
        msg = "O serviço de '" + vacina.getNome() + "' foi excluído!";
        alert = "danger";

        return "redirect:/servicos/vacina";
    }
}
