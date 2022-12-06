package br.edu.infnet.petshop.model.tests;

import br.edu.infnet.petshop.model.domain.Pet;

public class PetTest {
    public static void main(String[] args) {
        Pet p1 = new Pet("Lua", "25/04/2021", "Cachorro", "SRD", 'F', true);
        Pet p2 = new Pet("Lola", "28/11/2020", "Cachorro", "SRD", 'F', false);
        Pet p3 = new Pet("Teddy", "14/07/2002", "Cachorro", "Poodle", 'M', true);
        Pet p4 = new Pet("Morcego", "10/09/2020", "Gato", "SRD", 'M', true);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
    }
}
