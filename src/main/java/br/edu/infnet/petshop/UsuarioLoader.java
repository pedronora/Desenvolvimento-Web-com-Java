package br.edu.infnet.petshop;

import java.io.BufferedReader;
import java.io.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.petshop.model.domain.Endereco;
import br.edu.infnet.petshop.model.domain.Usuario;
import br.edu.infnet.petshop.service.UsuarioService;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {

    @Autowired
    UsuarioService usuarioService;

    String path = "src/main/resources/static/data/";
    String file = "usuario.txt";

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Endereco endereco1 = new Endereco("88015-905", "Rua Esteves Jr", "395", "Sala 610", "Centro", "Florianópolis", "SC");

        Usuario admin = new Usuario("Administrador", "admin@admin.com", "12345");
        admin.setAdmin(true);
        admin.setEndereco(endereco1);

        usuarioService.create(admin);
        System.out.println("Administrador criado!\nLogin: "+ admin.getEmail() + "\nSenha: " + admin.getSenha() + "\n");

        try {
            FileReader fileReader = new FileReader(path + file);
            BufferedReader reader = new BufferedReader(fileReader);

            String linha = reader.readLine();
            String[] campos = null;

            while (linha != null) {
                campos = linha.split(";");

                Usuario usuario = new Usuario(campos[1],campos[2]);
                usuario.setNome(campos[0]);
                usuario.setAdmin(false);

                Endereco endereco2 = new Endereco("20010-020", "Rua São José", "90", "", "Centro", "Rio de Janeiro", "RJ");

                usuario.setEndereco(endereco2);

                usuarioService.create(usuario);
                linha = reader.readLine();
            }

            fileReader.close();
            reader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("\n\tUsuários adicionados!\n");
        }
    }   
}
