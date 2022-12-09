package br.edu.infnet.petshop.model.tests;

import br.edu.infnet.petshop.model.domain.Banho;
import br.edu.infnet.petshop.model.domain.Consulta;
import br.edu.infnet.petshop.model.domain.Vacina;

public class ServicoTest {
    
    public static void main(String[] args) {
        Banho b1 = new Banho("Banho", 55.9f, 60, false, true, false);
        b1.setHidratarPelo(true);

        Vacina v1 = new Vacina("V10", 20, 15, "Obrigatória", "VanguardPlus", 100);
        v1.setPrecoVacina(99.99f);

        Consulta c1 = new Consulta("Consulta", 120.0f, 30, false, "Inflamação cutânea", "Antiinflamatório em spray");
        c1.setPlantao(true);

        System.out.println(b1);
        System.out.println(v1);
        System.out.println(c1);
    }
}
