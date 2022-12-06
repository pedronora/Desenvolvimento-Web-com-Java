package br.edu.infnet.petshop.model.tests;

import br.edu.infnet.petshop.model.domain.Atendimento;
import br.edu.infnet.petshop.model.domain.Pet;

public class AtendimentoTest {
    public static void main(String[] args) {
        Pet p1 = new Pet("Lua", "25/04/2021", "Cachorro", "SRD", 'F', true);
        Pet p2 = new Pet("Lola", "28/11/2020", "Cachorro", "SRD", 'F', false);
        Pet p3 = new Pet("Teddy", "14/07/2002", "Cachorro", "Poodle", 'M', true);


        Atendimento a1 = new Atendimento();
        a1.setDescricao("Primeiro Atendimento");;
        a1.setEmergencia(true);;
        a1.setPet(p1);
       
        Atendimento a2 = new Atendimento();
        a2.setDescricao("Segundo atendimento");
        a2.setEmergencia(false);
        a2.setPet(p2);

        Atendimento a3 = new Atendimento();
        a3.setDescricao("Terceiro atendimento");
        a3.setEmergencia(false);
        a3.setPet(p3);

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
    }
}
