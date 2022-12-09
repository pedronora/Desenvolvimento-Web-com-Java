package br.edu.infnet.petshop.model.tests;

import br.edu.infnet.petshop.model.domain.Consulta;

public class ConsultaTest {
    public static void main(String[] args) {
        Consulta c1 = new Consulta("Consulta", 120.0f, 30, false, "Inflamação cutânea", "Antiinflamatório em spray");

        Consulta c2 = new Consulta("Consulta", 120.0f, 30, true, "Inflamação cutânea", "Antiinflamatório em spray");

        System.out.println(c1);
        System.out.println(c2);
    }
}
