package br.edu.infnet.petshop.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.petshop.model.domain.Banho;

@Repository
public class BanhoRepository {
    private static Integer id = 1;
    private static Map<Integer, Banho> mapBanho = new HashMap<Integer, Banho>();

    public static boolean create(Banho banho) {
        try {
            banho.setId(id++);
            mapBanho.put(banho.getId(), banho);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Banho getById(Integer id) {
        Banho banho = mapBanho.get(id);
        return banho;
    }

    public static boolean editar(Banho banho) {
        try {
            mapBanho.put(banho.getId(), banho);
            return true;
        }  catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Banho delete(Integer id) {
        Banho banho = mapBanho.remove(id);
        return banho;
    }

    public static Collection<Banho> obterLista() {
        return mapBanho.values();
    }
}
