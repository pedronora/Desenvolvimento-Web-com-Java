package br.edu.infnet.petshop.model.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.infnet.petshop.model.domain.Usuario;

@Repository
public class AcessoRepository {
    static public Boolean autenticar(Usuario usuario) {
        List<Usuario> lista = UsuarioRepository.obterLista();

        for (Usuario user : lista) {
            if (usuario.getEmail().equalsIgnoreCase(user.getEmail()) &&
                usuario.getSenha().equals(user.getSenha())) {
                    return true;
                }
        }
        return false;
    }
}
