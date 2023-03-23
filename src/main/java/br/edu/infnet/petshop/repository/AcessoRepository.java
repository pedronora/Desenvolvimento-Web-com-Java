package br.edu.infnet.petshop.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.infnet.petshop.model.domain.Usuario;

@Repository
public class AcessoRepository {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario auth(Usuario usuario) {
        Collection<Usuario> lista = (Collection<Usuario>)usuarioRepository.findAll();

        for (Usuario user : lista) {
            if (usuario.getEmail().equalsIgnoreCase(user.getEmail()) &&
                    usuario.getSenha().equals(user.getSenha())) {
                return user;
            }
        }
        return null;
    }
}
