package br.edu.infnet.petshop.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.petshop.model.domain.Usuario;
import br.edu.infnet.petshop.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean create(Usuario usuario) {
        return usuarioRepository.create(usuario);
    }

    public Usuario getById(Integer id) {
        return usuarioRepository.getById(id);
    }

    public Boolean update(Usuario suario) {
        return usuarioRepository.update(suario);
    }

    public Usuario delete(Integer id) {
        return usuarioRepository.delete(id);
    }

    public Collection<Usuario> getAll() {
        return usuarioRepository.getAll();
    }
}
