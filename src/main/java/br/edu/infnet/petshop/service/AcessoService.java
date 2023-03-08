package br.edu.infnet.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.petshop.model.domain.Usuario;
import br.edu.infnet.petshop.repository.AcessoRepository;

@Service
public class AcessoService {
    @Autowired
    private AcessoRepository acessoRepository;

    public Usuario auth(Usuario usuario) {
        return acessoRepository.auth(usuario);
    }
    
}
