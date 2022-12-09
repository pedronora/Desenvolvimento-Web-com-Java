package br.edu.infnet.petshop.model.tests;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.petshop.model.domain.*;
import br.edu.infnet.petshop.model.exceptions.IllegalMinutesServiceException;
import br.edu.infnet.petshop.model.exceptions.InvalidFieldException;
import br.edu.infnet.petshop.model.exceptions.NoPriceException;

public class AtendimentoTest {
    public static void main(String[] args) {
        List<Servico> servicos1 = new ArrayList<Servico>();
        List<Servico> servicos2 = new ArrayList<Servico>();
        List<Servico> servicos3 = new ArrayList<Servico>();

        try {
            Banho b1 = new Banho("Banho", 55.9f, 60, false, true, false);
            b1.setHidratarPelo(true);
            servicos1.add(b1);
            servicos2.add(b1);
            servicos3.add(b1);
        } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Vacina v1 = new Vacina("Vacina - V10", 20, 15, "Obrigatória", "VanguardPlus", 100);
            v1.setPrecoVacina(99.99f);
            servicos2.add(v1);
            servicos3.add(v1);
        } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Consulta c1 = new Consulta("Consulta", 120.0f, 30, false, "Inflamação cutânea",
                    "Antiinflamatório em spray");
            c1.setPlantao(true);
            servicos3.add(c1);
        } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Pet p1 = new Pet("Lua", "25/04/2021", "Cachorro", "SRD", 'F', true);

            Atendimento a1 = new Atendimento();
            a1.setDescricao("Primeiro Atendimento");
            a1.setEmergencia(true);
            a1.setServicos(servicos1);
            a1.setPet(p1);
            a1.imprimir();
        } catch (InvalidFieldException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Pet p2 = new Pet("Lola", "28/11/2020", "Cachorro", "SRD", 'F', false);

            Atendimento a2 = new Atendimento();
            a2.setDescricao("Segundo atendimento");
            a2.setEmergencia(false);
            a2.setServicos(servicos2);
            a2.setPet(p2);
            a2.imprimir();
        } catch (InvalidFieldException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Pet p3 = new Pet("Teddy", "14/07/2002", "Cachorro", "Poodle", 'M', true);

            Atendimento a3 = new Atendimento();
            a3.setDescricao("Terceiro atendimento");
            a3.setEmergencia(false);
            a3.setServicos(servicos3);
            a3.setPet(p3);
            a3.imprimir();
        } catch (InvalidFieldException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
