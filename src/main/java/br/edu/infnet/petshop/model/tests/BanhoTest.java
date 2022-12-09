package br.edu.infnet.petshop.model.tests;

import br.edu.infnet.petshop.model.domain.Banho;

public class BanhoTest {
    public static void main(String[] args) {
        Banho b1 = new Banho("Banho", 55.9f, 60, false, true, false);

        Banho b2 = new Banho("Banho Premium", 55.9f, 90, true, true, true);

        Banho b3 = new Banho("Banho c/ Higiêne Bocal", 55.9f, 75, false, true, true);

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }
}
