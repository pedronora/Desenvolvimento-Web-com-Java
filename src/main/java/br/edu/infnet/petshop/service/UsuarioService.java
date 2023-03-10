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

    public Usuario auth(Usuario usuario) {
        return usuarioRepository.auth(usuario.getEmail(), usuario.getSenha());
    }

    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario getById(Integer id) {
        return usuarioRepository.findById(id).get();
    }

    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Collection<Usuario> getAll() {
        return (Collection<Usuario>)usuarioRepository.findAll();
    }
}
