package br.edu.infnet.petshop.model.tests;

import br.edu.infnet.petshop.model.domain.Atendimento;
import br.edu.infnet.petshop.model.domain.Pet;

public class AtendimentoTest {
    public static void main(String[] args) {
        Atendimento a1 = new Atendimento();
        a1.setDescricao("Primeiro Atendimento");;
        a1.setEmergencia(true);;
        a1.setPet(new Pet("Lua", "25/04/2022", "Cachorro", "SRD", 'F', false));
       
        Atendimento a2 = new Atendimento();
        a2.setDescricao("Segundo atendimento");
        a2.setEmergencia(false);

        Atendimento a3 = new Atendimento();
        a3.setDescricao("Terceiro atendimento");
        a2.setEmergencia(false);

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
    }
}
