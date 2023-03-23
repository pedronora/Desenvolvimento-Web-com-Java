package br.edu.infnet.petshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.petshop.model.domain.Banho;

public interface BanhoRepository extends CrudRepository<Banho, Integer>{
    @Query("from Banho b where b.usuario.id = :id")
    List<Banho> findAllByUsuario(Integer id);
}
