package br.edu.infnet.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.petshop.model.domain.Pet;
import br.edu.infnet.petshop.service.PetService;

@Controller
public class PetController {
    private String msg;
    private String alert;

    @Autowired
    PetService petService;

    @GetMapping(value = "/pet/cadastro")
    public String telaCadastro() {
        return "/pet/cadastro";
    }

    @GetMapping(value = "/pet")
    public String telaLista(Model model) {
        model.addAttribute("pets", petService.getAll());
        model.addAttribute("mensagem", msg);
        model.addAttribute("alerta", alert);
        msg = null;

        return "/pet/lista";
    }

    @PostMapping(value = "/pet/incluir")
    public String create(Pet pet) {
        petService.create(pet);
        msg = "A inclusão do pet '" + pet.getNome() + "' foi realizada com sucesso!";
        alert = "success";

        return "redirect:/pet";
    }

    @GetMapping(value = "/pet/{id}/detalhes")
    public String details(Model model, @PathVariable Integer id) {
        Pet pet = petService.getById(id);
        model.addAttribute("pet", pet);
        return "/pet/detalhes";
    }

    @GetMapping(value = "/pet/{id}/editar")
    public String update(Model model, @PathVariable Integer id) {
        Pet pet = petService.getById(id);
        model.addAttribute("pet", pet);
        return "/pet/editar";
    }

    @PostMapping(value = "/pet/editar")
    public String updated(Pet pet) {
        petService.update(pet);
        msg = "As informações do pet '" + pet.getNome() + "' foram atualizadas com sucesso!";
        alert = "success";

        return "redirect:/pet";
    }

    @GetMapping(value = "/pet/{id}/excluir")
    public String delete(@PathVariable Integer id) {
        Pet pet = petService.delete(id);
        msg = "O pet '" + pet.getNome() + "' foi excluído!";
        alert = "danger";

        return "redirect:/pet";
    }
}
