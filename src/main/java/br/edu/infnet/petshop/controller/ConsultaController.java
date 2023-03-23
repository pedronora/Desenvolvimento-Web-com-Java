package br.edu.infnet.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.petshop.model.domain.Consulta;
import br.edu.infnet.petshop.model.domain.Usuario;
import br.edu.infnet.petshop.service.ConsultaService;

@Controller
public class ConsultaController {
    private String msg;
    private String alert;

    @Autowired
    ConsultaService consultaService;

    @GetMapping(value = "/servicos/consulta/cadastro")
    public String telaCadastro() {
        return "servicos/consulta/cadastro";
    }

    @GetMapping(value = "/servicos/consulta")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("consultas", consultaService.getAllByUsuario(usuario.getId()));
        model.addAttribute("mensagem", msg);
        model.addAttribute("alerta", alert);
        msg = null;

        return "servicos/consulta/lista";
    }

    @PostMapping(value = "/servicos/consulta/incluir")
    public String create(Consulta consulta,  @SessionAttribute("user") Usuario usuario) {
        consulta.setUsuario(usuario);
        consultaService.create(consulta);
        msg = "A inclusão do serviço '" + consulta.getNome() + "' foi realizada com sucesso!";
        alert = "success";

        return "redirect:/servicos/consulta";
    }

    @GetMapping(value = "/servicos/consulta/{id}/detalhes")
    public String details(Model model, @PathVariable Integer id) {
        Consulta consulta = consultaService.getById(id);
        model.addAttribute("consulta", consulta);
        return "servicos/consulta/detalhes";
    }

    @GetMapping(value = "/servicos/consulta/{id}/editar")
    public String update(Model model, @PathVariable Integer id) {
        Consulta consulta = consultaService.getById(id);
        model.addAttribute("consulta", consulta);
        return "servicos/consulta/editar";
    }

    @PostMapping(value = "/servicos/consulta/editar")
    public String updated(Consulta consulta,  @SessionAttribute("user") Usuario usuario) {
        consulta.setUsuario(usuario);
        consultaService.update(consulta);
        msg = "As informações do serviço '" + consulta.getNome() + "' foram atualizadas com sucesso!";
        alert = "success";

        return "redirect:/servicos/consulta";
    }

    @GetMapping(value = "/servicos/consulta/{id}/excluir")
    public String delete(@PathVariable Integer id) {
        Consulta consulta = consultaService.getById(id);
        consultaService.delete(id);
        msg = "O serviço de '" + consulta.getNome() + "' foi excluído!";
        alert = "danger";

        return "redirect:/servicos/consulta";
    }
}
