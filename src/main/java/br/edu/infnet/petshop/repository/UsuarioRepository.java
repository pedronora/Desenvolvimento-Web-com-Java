package br.edu.infnet.petshop.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.petshop.model.domain.Usuario;

@Repository
public class UsuarioRepository {
    private static Integer id = 1;
    private static Map<Integer, Usuario> mapUsuario = new HashMap<Integer, Usuario>();

    public static boolean create(Usuario usuario) {
        try {
            usuario.setId(id++);
            mapUsuario.put(usuario.getId(), usuario);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Usuario getById(Integer id) {
        Usuario usuario = mapUsuario.get(id);
        return usuario;
    }

    public static boolean editar(Usuario usuario) {
        try {
            mapUsuario.put(usuario.getId(), usuario);
            return true;
        }  catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Usuario delete(Integer key) {
        Usuario usuario = mapUsuario.remove(key);
        return usuario;
    }

    public static Collection<Usuario> obterLista() {
        return mapUsuario.values();
    }
}
