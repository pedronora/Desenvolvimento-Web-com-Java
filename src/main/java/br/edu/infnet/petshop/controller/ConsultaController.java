package br.edu.infnet.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.petshop.model.domain.Consulta;
import br.edu.infnet.petshop.repository.ConsultaRepository;

@Controller
public class ConsultaController {
    private String msg;
    private String alert;

    @GetMapping(value = "/servicos/consulta/cadastro")
    public String telaCadastro() {
        return "servicos/consulta/cadastro";
    }

    @GetMapping(value = "/servicos/consulta")
    public String telaLista(Model model) {
        model.addAttribute("consultas", ConsultaRepository.obterLista());
        model.addAttribute("mensagem", msg);
        model.addAttribute("alerta", alert);
        msg = null;

        return "servicos/consulta/lista";
    }

    @PostMapping(value = "/servicos/consulta/incluir")
    public String incluir(Consulta consulta) {
        ConsultaRepository.create(consulta);
        msg = "A inclusão do serviço '" + consulta.getNome() + "' foi realizada com sucesso!";
        alert = "success";

        return "redirect:/servicos/consulta";
    }

    @GetMapping(value = "/servicos/consulta/{id}/detalhes")
    public String detalhes(Model model, @PathVariable Integer id) {
        Consulta consulta = ConsultaRepository.getById(id);
        model.addAttribute("consulta", consulta);
        return "servicos/consulta/detalhes";
    }

    @GetMapping(value = "/servicos/consulta/{id}/editar")
    public String editar(Model model, @PathVariable Integer id) {
        Consulta consulta = ConsultaRepository.getById(id);
        model.addAttribute("consulta", consulta);
        return "servicos/consulta/editar";
    }

    @PostMapping(value = "/servicos/consulta/editar")
    public String editado(Consulta consulta) {
        ConsultaRepository.editar(consulta);
        msg = "As informações do serviço '" + consulta.getNome() + "' foram atualizadas com sucesso!";
        alert = "success";

        return "redirect:/servicos/consulta";
    }

    @GetMapping(value = "/servicos/consulta/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        Consulta consulta = ConsultaRepository.delete(id);
        msg = "O serviço de '" + consulta.getNome() + "' foi excluído!";
        alert = "danger";

        return "redirect:/servicos/consulta";
    }
}
