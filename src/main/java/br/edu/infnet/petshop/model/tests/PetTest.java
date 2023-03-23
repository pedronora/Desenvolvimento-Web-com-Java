package br.edu.infnet.petshop.model.tests;

import br.edu.infnet.petshop.model.domain.Pet;
import br.edu.infnet.petshop.model.exceptions.InvalidFieldException;

public class PetTest {
    public static void main(String[] args) {
        try {
            Pet p1 = new Pet("", "25/04/2021", "Cachorro", "SRD", 'F', true);
            System.out.println(p1);
        } catch (InvalidFieldException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Pet p2 = new Pet("Lola", "28/11/2020", null, "SRD", 'F', false);
            System.out.println(p2);
        } catch (InvalidFieldException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Pet p3 = new Pet("Teddy", "14/07/2002", "Cachorro", null, 'M', true);
            System.out.println(p3);
        } catch (InvalidFieldException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Pet p4 = new Pet("Morcego", "10/09/2020", "Gato", "SRD", 'M', true);
            System.out.println(p4);
        } catch (InvalidFieldException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
