package br.edu.infnet.petshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.petshop.model.domain.Pet;

public interface PetRepository extends CrudRepository<Pet, Integer> {
    @Query("from Pet p where p.usuario.id = :id")
    List<Pet> findAllByUsuario(Integer id);
}
