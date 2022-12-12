package br.edu.infnet.petshop.model.tests;

import br.edu.infnet.petshop.model.domain.Consulta;
import br.edu.infnet.petshop.model.exceptions.IllegalMinutesServiceException;
import br.edu.infnet.petshop.model.exceptions.InvalidFieldException;
import br.edu.infnet.petshop.model.exceptions.NoPriceException;

public class ConsultaTest {
    public static void main(String[] args) {
        try {
            Consulta c1 = new Consulta(null, 120.0f, 30, false, "Inflamação cutânea",
                    "Antiinflamatório em spray");
            System.out.println(c1);
        } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Consulta c2 = new Consulta("Consulta", 0, 30, false, "Inflamação cutânea",
                    "Antiinflamatório em spray");
            System.out.println(c2);
        } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Consulta c3 = new Consulta("Consulta", 120, 10, false, "Inflamação cutânea",
                    "Antiinflamatório em spray");
            System.out.println(c3);
        } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Consulta c4 = new Consulta("Consulta", 120, 11, false, "Inflamação cutânea",
                    "Antiinflamatório em spray");
            c4.setDescricao("    ");
            System.out.println(c4);
        } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Consulta c5 = new Consulta("Consulta", 120, 11, false, "Inflamação cutânea",
                    "Antiinflamatório em spray");
            c5.setReceita(null);
            System.out.println(c5);
        } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Consulta c6 = new Consulta("Consulta", 120.0f, 30, true, "Inflamação cutânea", "Antiinflamatório em spray");
            System.out.println(c6);
        } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
