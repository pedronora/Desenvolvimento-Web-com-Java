package br.edu.infnet.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.petshop.model.domain.Vacina;
import br.edu.infnet.petshop.repository.VacinaRepository;

@Controller
public class VacinaController {
    private String msg;
    private String alert;

    @GetMapping(value = "/servicos/vacina/cadastro")
    public String telaCadastro() {
        return "servicos/vacina/cadastro";
    }

    @GetMapping(value = "/servicos/vacina")
    public String telaLista(Model model) {
        model.addAttribute("vacinas", VacinaRepository.obterLista());
        model.addAttribute("mensagem", msg);
        model.addAttribute("alerta", alert);
        msg = null;

        return "servicos/vacina/lista";
    }

    @PostMapping(value = "/servicos/vacina/incluir")
    public String incluir(Vacina vacina) {
        VacinaRepository.create(vacina);
        msg = "A inclusão do serviço '" + vacina.getNome() + "' foi realizada com sucesso!";
        alert = "success";

        return "redirect:/servicos/vacina";
    }

    @GetMapping(value = "/servicos/vacina/{id}/detalhes")
    public String detalhes(Model model, @PathVariable Integer id) {
        Vacina vacina = VacinaRepository.getById(id);
        model.addAttribute("vacina", vacina);
        return "servicos/vacina/detalhes";
    }

    @GetMapping(value = "/servicos/vacina/{id}/editar")
    public String editar(Model model, @PathVariable Integer id) {
        Vacina vacina = VacinaRepository.getById(id);
        model.addAttribute("vacina", vacina);
        return "servicos/vacina/editar";
    }

    @PostMapping(value = "/servicos/vacina/editar")
    public String editado(Vacina vacina) {
        VacinaRepository.editar(vacina);
        msg = "As informações do serviço '" + vacina.getNome() + "' foram atualizadas com sucesso!";
        alert = "success";

        return "redirect:/servicos/vacina";
    }

    @GetMapping(value = "/servicos/vacina/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        Vacina vacina = VacinaRepository.delete(id);
        msg = "O serviço de '" + vacina.getNome() + "' foi excluído!";
        alert = "danger";

        return "redirect:/servicos/vacina";
    }
}
