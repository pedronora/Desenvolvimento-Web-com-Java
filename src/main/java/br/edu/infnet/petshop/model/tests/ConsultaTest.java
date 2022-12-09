package br.edu.infnet.petshop.model.tests;

import br.edu.infnet.petshop.model.domain.Consulta;
import br.edu.infnet.petshop.model.exceptions.IllegalMinutesServiceException;
import br.edu.infnet.petshop.model.exceptions.InvalidFieldException;
import br.edu.infnet.petshop.model.exceptions.NoPriceException;

public class ConsultaTest {
    public static void main(String[] args) {
        try {
            Consulta c1 = new Consulta("Consulta", 120.0f, 30, false, "Inflamação cutânea",
                    "Antiinflamatório em spray");
            System.out.println(c1);
        } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Consulta c2 = new Consulta("Consulta", 120.0f, 30, true, "Inflamação cutânea", "Antiinflamatório em spray");
            System.out.println(c2);
        } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
