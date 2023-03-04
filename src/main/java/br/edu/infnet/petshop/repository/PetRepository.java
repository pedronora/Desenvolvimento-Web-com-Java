package br.edu.infnet.petshop.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.petshop.model.domain.Pet;

@Repository
public class PetRepository {
    private static Integer id = 1;
    private static Map<Integer, Pet> mapPet = new HashMap<Integer, Pet>();

    public static boolean create(Pet pet) {
        try {
            pet.setId(id++);
            mapPet.put(pet.getId(), pet);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Pet getById(Integer id) {
        Pet pet = mapPet.get(id);
        return pet;
    }

    public static boolean editar(Pet pet) {
        try {
            mapPet.put(pet.getId(), pet);
            return true;
        }  catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Pet delete(Integer id) {
        Pet pet = mapPet.remove(id);
        return pet;
    }

    public static Collection<Pet> obterLista() {
        return mapPet.values();
    }
}
