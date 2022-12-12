package br.edu.infnet.petshop.model.tests;

import br.edu.infnet.petshop.model.domain.Vacina;
import br.edu.infnet.petshop.model.exceptions.IllegalMinutesServiceException;
import br.edu.infnet.petshop.model.exceptions.InvalidFieldException;
import br.edu.infnet.petshop.model.exceptions.NoPriceException;

public class VacinaTest {
    public static void main(String[] args) {
        try {
            Vacina v1 = new Vacina("", 20, 15, "Obrigatória", "VanguardPlus", 100);
            System.out.println(v1);
        } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Vacina v2 = new Vacina("V10", 20, 15, null, "VanguardPlus", 100);
            System.out.println(v2);
        } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Vacina v3 = new Vacina("Influenza", 0, 15, "Facultativa", "Nobivac", 80);
            System.out.println(v3);
        } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Vacina v4 = new Vacina("Raiva", 20, 10, "Obrigatória", "Nobivac", 110);
            System.out.println(v4);
        } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Vacina v5 = new Vacina("Raiva", 20, 11, "Obrigatória", "Nobivac", 0);
            System.out.println(v5);
        } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Vacina v6 = new Vacina("Raiva", 20, 11, "Obrigatória", "Nobivac", 1);
            v6.setPrecoVacina(0);
            System.out.println(v6);
        } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Vacina v7 = new Vacina("V10", 20, 15, "Obrigatória", "Nobivac", 110);
            System.out.println(v7);
        } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
