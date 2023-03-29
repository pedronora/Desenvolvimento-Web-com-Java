package br.edu.infnet.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.petshop.model.domain.Servico;
import br.edu.infnet.petshop.model.domain.Usuario;
import br.edu.infnet.petshop.service.ServicoService;

@Controller
public class ServicoController {
    private String msg;
    private String alert;

    @Autowired
    ServicoService servicoService;

    // @GetMapping(value = "/servicos/cadastro")
    // public String telaCadastro() {
    //     return "servicos/servico/cadastro";
    // }

    @GetMapping(value = "/servicos")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("servicos", servicoService.getAllByUsuario(usuario.getId()));
        model.addAttribute("mensagem", msg);
        model.addAttribute("alerta", alert);
        msg = null;

        return "servicos/lista";
    }

    // @PostMapping(value = "/servicos/incluir")
    // public String create(Servico servico) {
    //     servicoService.create(servico);
    //     msg = "A inclusão do serviço '" + servico.getNome() + "' foi realizada com sucesso!";
    //     alert = "success";

    //     return "redirect:/servicos";
    // }

    // @GetMapping(value = "/servicos/{id}/detalhes")
    // public String details(Model model, @PathVariable Integer id) {
    //     Servico servico = servicoService.getById(id);
    //     model.addAttribute("servico", servico);
    //     return "servicos/detalhes";
    // }

    // @GetMapping(value = "/servicos/{id}/editar")
    // public String update(Model model, @PathVariable Integer id) {
    //     Servico servico = servicoService.getById(id);
    //     model.addAttribute("servico", servico);
    //     return "servicos/servico/editar";
    // }

    // @PostMapping(value = "/servicos/editar")
    // public String updated(Servico servico) {
    //     servicoService.update(servico);
    //     msg = "As informações do serviço '" + servico.getNome() + "' foram atualizadas com sucesso!";
    //     alert = "success";

    //     return "redirect:/servicos";
    // }

    @GetMapping(value = "/servicos/{id}/excluir")
    public String delete(@PathVariable Integer id) {
        Servico servico = servicoService.getById(id);
        alert = "danger";

        try {
            servicoService.delete(id);
            msg = "O serviço de '" + servico.getNome() + "' foi excluído!";
            
        } catch (Exception e) {
            msg = "O servico '" + servico.getNome() +"' está associado a um atendimento! Não é possível excluí-lo!" ;
            System.out.println(e.getMessage());
        }

        return "redirect:/servicos";
    }
}
