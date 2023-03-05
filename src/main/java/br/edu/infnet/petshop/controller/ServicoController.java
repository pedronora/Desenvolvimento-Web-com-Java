package br.edu.infnet.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import br.edu.infnet.petshop.repository.ServicoRepository;

@Controller
public class ServicoController {
    private String msg;
    private String alert;

    // @GetMapping(value = "/servicos/cadastro")
    // public String telaCadastro() {
    //     return "/servicos/cadastro";
    // }

    @GetMapping(value = "/servicos")
    public String telaLista(Model model) {
        model.addAttribute("servicos", ServicoRepository.obterLista());
        model.addAttribute("mensagem", msg);
        model.addAttribute("alerta", alert);
        msg = null;

        return "servicos/lista";
    }

    // @PostMapping(value = "/servicos/incluir")
    // public String incluir(Servico servico) {
    //     ServicoRepository.create(servico);
    //     msg = "A inclusão do serviço '" + servico.getNome() + "' foi realizada com sucesso!";
    //     alert = "success";

    //     return "redirect:/servicos";
    // }

    // @GetMapping(value = "/servicos/{id}/detalhes")
    // public String detalhes(Model model, @PathVariable Integer id) {
    //     Servico servico = ServicoRepository.getById(id);
    //     model.addAttribute("servico", servico);
    //     return "servicos/detalhes";
    // }

    // @GetMapping(value = "/servicos/{id}/editar")
    // public String editar(Model model, @PathVariable Integer id) {
    //     Servico servico = ServicoRepository.getById(id);
    //     model.addAttribute("servico", servico);
    //     return "servicos/editar";
    // }

    // @PostMapping(value = "/servicos/editar")
    // public String editado(Servico servico) {
    //     ServicoRepository.editar(servico);
    //     msg = "As informações do serviço '" + servico.getNome() + "' foram atualizadas com sucesso!";
    //     alert = "success";

    //     return "redirect:/servicos";
    // }

    // @GetMapping(value = "/servicos/{id}/excluir")
    // public String excluir(@PathVariable Integer id) {
    //     Servico servico = ServicoRepository.delete(id);
    //     msg = "O serviço de '" + servico.getNome() + "' foi excluído!";
    //     alert = "danger";

    //     return "redirect:/servicos";
    // }
}
