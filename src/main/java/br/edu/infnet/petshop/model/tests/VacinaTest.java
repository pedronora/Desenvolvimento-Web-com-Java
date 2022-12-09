package br.edu.infnet.petshop.model.tests;

import br.edu.infnet.petshop.model.domain.Vacina;

public class VacinaTest {
    public static void main(String[] args) {
        Vacina v1 = new Vacina("V10", 20, 15, "Obrigatória", "VanguardPlus", 100);

        Vacina v2 = new Vacina("Influenza", 20, 15, "Facultativa", "Nobivac", 80);

        Vacina v3 = new Vacina("Raiva", 20, 15, "Obrigatória", "Nobivac", 110);


        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
    }
}
