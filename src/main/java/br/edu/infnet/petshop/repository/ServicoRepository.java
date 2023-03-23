package br.edu.infnet.petshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.petshop.model.domain.Servico;

public interface ServicoRepository extends CrudRepository<Servico, Integer> {
    @Query("from Servico s where s.usuario.id = :id")
    List<Servico> findAllByUsuario(Integer id);
}
