package br.edu.infnet.petshop.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.petshop.model.domain.Consulta;

public interface ConsultaRepository extends CrudRepository<Consulta, Integer> {
    @Query("from Consulta c where c.usuario.id = :id")
    List<Consulta> findAllByUsuario(Integer id, Sort sort);
}
