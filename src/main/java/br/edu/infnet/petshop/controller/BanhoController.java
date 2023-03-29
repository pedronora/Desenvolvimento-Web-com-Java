package br.edu.infnet.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.petshop.model.domain.Banho;
import br.edu.infnet.petshop.model.domain.Usuario;
import br.edu.infnet.petshop.service.BanhoService;

@Controller
public class BanhoController {
    private String msg;
    private String alert;

    @Autowired
    BanhoService banhoService;

    @GetMapping(value = "/servicos/banho/cadastro")
    public String telaCadastro() {
        return "servicos/banho/cadastro";
    }

    @GetMapping(value = "/servicos/banho")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("banhos", banhoService.getAllByUsuario(usuario.getId()));
        model.addAttribute("mensagem", msg);
        model.addAttribute("alerta", alert);
        msg = null;

        return "servicos/banho/lista";
    }

    @PostMapping(value = "/servicos/banho/incluir")
    public String create(Banho banho, @SessionAttribute("user") Usuario usuario) {
        banho.setUsuario(usuario);
        banhoService.create(banho);  
        msg = "A inclusão do serviço '" + banho.getNome() + "' foi realizada com sucesso!";
        alert = "success";

        return "redirect:/servicos/banho";
    }

    @GetMapping(value = "/servicos/banho/{id}/detalhes")
    public String details(Model model, @PathVariable Integer id) {
        Banho banho = banhoService.getById(id);
        model.addAttribute("banho", banho);
        return "servicos/banho/detalhes";
    }

    @GetMapping(value = "/servicos/banho/{id}/editar")
    public String update(Model model, @PathVariable Integer id) {
        Banho banho = banhoService.getById(id);
        model.addAttribute("banho", banho);
        return "servicos/banho/editar";
    }

    @PostMapping(value = "/servicos/banho/editar")
    public String updated(Banho banho,  @SessionAttribute("user") Usuario usuario) {
        banho.setUsuario(usuario);
        banhoService.update(banho);
        msg = "As informações do serviço '" + banho.getNome() + "' foram atualizadas com sucesso!";
        alert = "success";

        return "redirect:/servicos/banho";
    }

    @GetMapping(value = "/servicos/banho/{id}/excluir")
    public String delete(@PathVariable Integer id) {
        Banho banho = banhoService.getById(id);
        alert = "danger";

        try {
            banhoService.delete(id);
            msg = "O serviço de '" + banho.getNome() + "' foi excluído!";
            
        } catch (Exception e) {
            msg = "O servico de '" + banho.getNome() +"' está associado a um atendimento! Não é possível excluí-lo!" ;
            System.out.println(e.getMessage());
        }

        return "redirect:/servicos/banho";
    }
}
