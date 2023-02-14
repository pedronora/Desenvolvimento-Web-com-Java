package br.edu.infnet.petshop.model.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.infnet.petshop.model.domain.Usuario;

@Repository
public class UsuarioRepository {
    static private List<Usuario> lista = new ArrayList<Usuario>();

    public static boolean add(Usuario usuario) {
        try {
            lista.add(usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static List<Usuario> obterLista() {
        return lista;
    }
}
