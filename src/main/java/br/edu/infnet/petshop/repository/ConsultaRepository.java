package br.edu.infnet.petshop.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.petshop.model.domain.Consulta;

@Repository
public class ConsultaRepository {
    private static Integer id = 1;
    private static Map<Integer, Consulta> mapConsulta = new HashMap<Integer, Consulta>();

    public static boolean create(Consulta consulta) {
        try {
            consulta.setId(id++);
            mapConsulta.put(consulta.getId(), consulta);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Consulta getById(Integer id) {
        Consulta Consulta = mapConsulta.get(id);
        return Consulta;
    }

    public static boolean editar(Consulta consulta) {
        try {
            mapConsulta.put(consulta.getId(), consulta);
            return true;
        }  catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Consulta delete(Integer id) {
        Consulta consulta = mapConsulta.remove(id);
        return consulta;
    }

    public static Collection<Consulta> obterLista() {
        return mapConsulta.values();
    }
}
