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

    public Boolean create(Pet pet) {
        return petRepository.create(pet);
    }

    public Pet getById(Integer id) {
        return petRepository.getById(id);
    }

    public Boolean update(Pet pet) {
        return petRepository.update(pet);
    }

    public Pet delete(Integer id) {
        return petRepository.delete(id);
    }

    public Collection<Pet> getAll() {
        return petRepository.getAll();
    }
}
