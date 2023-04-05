package br.edu.infnet.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.petshop.model.domain.Endereco;
import br.edu.infnet.petshop.model.domain.Pet;
import br.edu.infnet.petshop.model.domain.Usuario;
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
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("pets", petService.getAllByUsuario(usuario.getId()));
        model.addAttribute("mensagem", msg);
        model.addAttribute("alerta", alert);
        msg = null;

        return "/pet/lista";
    }

    @PostMapping(value = "/pet/incluir")
    public String create(Pet pet, @SessionAttribute("user") Usuario usuario, Endereco endereco) {
        pet.setUsuario(usuario);
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
        model.addAttribute("endereco", pet.getEndereco());
        return "/pet/editar";
    }

    @PostMapping(value = "/pet/editar")
    public String updated(Pet pet, @SessionAttribute("user") Usuario usuario, Endereco endereco) {
        pet.setUsuario(usuario);
        petService.update(pet);
        msg = "As informações do pet '" + pet.getNome() + "' foram atualizadas com sucesso!";
        alert = "success";

        return "redirect:/pet";
    }

    @GetMapping(value = "/pet/{id}/excluir")
    public String delete(@PathVariable Integer id) {
        Pet pet = petService.getById(id);
        alert = "danger";

        try {
            petService.delete(id);
            msg = "O pet '" + pet.getNome() + "' foi excluído!";
        } catch (Exception e) {
            msg = "O pet '" + pet.getNome() + "' está associado a um atendimento e não pode ser excluído!";
        }



        return "redirect:/pet";
    }
}
