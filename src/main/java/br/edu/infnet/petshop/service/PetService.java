package br.edu.infnet.petshop.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.petshop.model.domain.Pet;
import br.edu.infnet.petshop.repository.PetRepository;

@Service
public class PetService {
    
    @Autowired
    PetRepository petRepository;

    public Pet create(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet getById(Integer id) {
        return petRepository.findById(id).get();
    }

    public Pet update(Pet pet) {
        return petRepository.save(pet);
    }

    public void delete(Integer id) {
        petRepository.deleteById(id);
    }

    public Collection<Pet> getAll() {
        return (Collection<Pet>)petRepository.findAll();
    }

    public Collection<Pet> getAllById(Integer id) {
        return petRepository.getAllByUsuario(id);
    }
}
