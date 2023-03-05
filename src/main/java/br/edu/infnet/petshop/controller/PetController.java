package br.edu.infnet.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.petshop.model.domain.Pet;
import br.edu.infnet.petshop.repository.PetRepository;

@Controller
public class PetController {
    private String msg;
    private String alert;

    @GetMapping(value = "/pet/cadastro")
    public String telaCadastro() {
        return "/pet/cadastro";
    }

    @GetMapping(value = "/pet")
    public String telaLista(Model model) {
        model.addAttribute("pets", PetRepository.obterLista());
        model.addAttribute("mensagem", msg);
        model.addAttribute("alerta", alert);
        msg = null;

        return "/pet/lista";
    }

    @PostMapping(value = "/pet/incluir")
    public String incluir(Pet pet) {
        PetRepository.create(pet);
        msg = "A inclusão do pet '" + pet.getNome() + "' foi realizada com sucesso!";
        alert = "success";

        return "redirect:/pet";
    }

    @GetMapping(value = "/pet/{id}/detalhes")
    public String detalhes(Model model, @PathVariable Integer id) {
        Pet pet = PetRepository.getById(id);
        model.addAttribute("pet", pet);
        return "/pet/detalhes";
    }

    @GetMapping(value = "/pet/{id}/editar")
    public String editar(Model model, @PathVariable Integer id) {
        Pet pet = PetRepository.getById(id);
        model.addAttribute("pet", pet);
        return "/pet/editar";
    }

    @PostMapping(value = "/pet/editar")
    public String editado(Pet pet) {
        PetRepository.editar(pet);
        msg = "As informações do pet '" + pet.getNome() + "' foram atualizadas com sucesso!";
        alert = "success";

        return "redirect:/pet";
    }

    @GetMapping(value = "/pet/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        Pet pet = PetRepository.delete(id);
        msg = "O pet '" + pet.getNome() + "' foi excluído!";
        alert = "danger";

        return "redirect:/pet";
    }
}
