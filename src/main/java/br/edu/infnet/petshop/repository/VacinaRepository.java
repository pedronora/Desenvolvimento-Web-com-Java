package br.edu.infnet.petshop.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.petshop.model.domain.Vacina;

@Repository
public class VacinaRepository {
    private static Integer id = 1;
    private static Map<Integer, Vacina> mapVacina = new HashMap<Integer, Vacina>();

    public static boolean create(Vacina vacina) {
        try {
            vacina.setId(id++);
            mapVacina.put(vacina.getId(), vacina);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Vacina getById(Integer id) {
        Vacina vacina = mapVacina.get(id);
        return vacina;
    }

    public static boolean editar(Vacina vacina) {
        try {
            mapVacina.put(vacina.getId(), vacina);
            return true;
        }  catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Vacina delete(Integer id) {
        Vacina vacina = mapVacina.remove(id);
        return vacina;
    }

    public static Collection<Vacina> obterLista() {
        return mapVacina.values();
    }
}
