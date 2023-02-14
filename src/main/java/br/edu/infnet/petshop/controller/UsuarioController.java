package br.edu.infnet.petshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.petshop.model.domain.Usuario;
import br.edu.infnet.petshop.model.repository.UsuarioRepository;

@Controller
public class UsuarioController {

    @GetMapping(value = "/usuario")
    public String telaCadastro() {
        return "usuario/cadastro";
    }

    @GetMapping(value = "/usuario/lista")
    public String telaList() {
        List<Usuario> lista = UsuarioRepository.obterLista();
        System.out.println("Quantida de usuários = " + lista.size());

        for (Usuario usuario : lista) {
            System.out.println("Nome: " + usuario.getNome() + "; Email: " + usuario.getEmail());
        }
        return "usuario/lista";
    }

    @PostMapping(value = "/usuario/incluir")
    public String incluir(Usuario usuario) {
        UsuarioRepository.add(usuario);
        System.out.println("Inclusão realizada com sucesso: " + usuario);
        return "redirect:/usuario/lista";
    }
}