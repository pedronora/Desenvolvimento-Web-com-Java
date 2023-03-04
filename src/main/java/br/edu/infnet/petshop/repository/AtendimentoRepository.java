package br.edu.infnet.petshop.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.petshop.model.domain.Atendimento;

@Repository
public class AtendimentoRepository {
    private static Integer id = 1;
    private static Map<Integer, Atendimento> mapAtendimento = new HashMap<Integer, Atendimento>();

    public static boolean create(Atendimento atendimento) {
        try {
            atendimento.setId(id++);
            mapAtendimento.put(atendimento.getId(), atendimento);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Atendimento getById(Integer id) {
        Atendimento atendimento = mapAtendimento.get(id);
        return atendimento;
    }

    public static boolean editar(Atendimento atendimento) {
        try {
            mapAtendimento.put(atendimento.getId(), atendimento);
            return true;
        }  catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Atendimento delete(Integer id) {
        Atendimento atendimento = mapAtendimento.remove(id);
        return atendimento;
    }

    public static Collection<Atendimento> obterLista() {
        return mapAtendimento.values();
    }
}
