package br.edu.infnet.petshop.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.petshop.model.domain.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    @Query("from Usuario u where u.email = :email and u.senha = :senha")
    Usuario auth(String email, String senha);
}