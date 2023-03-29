package br.edu.infnet.petshop.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.petshop.model.domain.Vacina;

public interface VacinaRepository extends CrudRepository<Vacina, Integer> {
    @Query("from Vacina v where v.usuario.id = :id")
    List<Vacina> findAllByUsuario(Integer id, Sort sort);
} 
