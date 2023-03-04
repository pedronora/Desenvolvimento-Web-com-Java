package br.edu.infnet.petshop.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.petshop.model.domain.Servico;

@Repository
public class ServicoRepository {
    private static Integer id = 1;
    private static Map<Integer, Servico> mapServico = new HashMap<Integer, Servico>();

    public static boolean create(Servico servico) {
        try {
            servico.setId(id++);
            mapServico.put(servico.getId(), servico);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Servico getById(Integer id) {
        Servico servico = mapServico.get(id);
        return servico;
    }

    public static boolean editar(Servico servico) {
        try {
            mapServico.put(servico.getId(), servico);
            return true;
        }  catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Servico delete(Integer id) {
        Servico servico = mapServico.remove(id);
        return servico;
    }

    public static Collection<Servico> obterLista() {
        return mapServico.values();
    }
}
