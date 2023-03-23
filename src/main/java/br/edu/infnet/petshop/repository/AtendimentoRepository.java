package br.edu.infnet.petshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.petshop.model.domain.Atendimento;

public interface AtendimentoRepository extends CrudRepository<Atendimento, Integer> {
    @Query("from Atendimento a where a.usuario.id = :id")
    List<Atendimento> findAllByUsuario(Integer id);
}
