package br.edu.infnet.petshop.model.tests;

import br.edu.infnet.petshop.model.domain.Banho;
import br.edu.infnet.petshop.model.exceptions.IllegalMinutesServiceException;
import br.edu.infnet.petshop.model.exceptions.InvalidFieldException;
import br.edu.infnet.petshop.model.exceptions.NoPriceException;

public class BanhoTest {
    public static void main(String[] args) {
        try {
            Banho b1 = new Banho("Banho", 0, 60, false, true, false);
            System.out.println(b1);

        } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Banho b2 = new Banho("Banho Premium", 55.9f, 90, true, true, true);
            System.out.println(b2);
        } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Banho b3 = new Banho("Banho c/ Higiêne Bocal", 55.9f, 75, false, true, true);
            System.out.println(b3);
        } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
