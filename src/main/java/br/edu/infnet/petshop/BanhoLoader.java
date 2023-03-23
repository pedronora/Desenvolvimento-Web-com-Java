package br.edu.infnet.petshop;

import java.io.BufferedReader;
import java.io.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.petshop.model.domain.Banho;
import br.edu.infnet.petshop.model.domain.Usuario;
import br.edu.infnet.petshop.service.BanhoService;

@Component
public class BanhoLoader implements ApplicationRunner {

    @Autowired
    BanhoService banhoService;

    String path = "src/main/resources/static/data/";
    String file = "banho.txt";

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            FileReader fileReader = new FileReader(path + file);
            BufferedReader reader = new BufferedReader(fileReader);

            String linha = reader.readLine();
            String[] campos = null;

            Usuario usuario = new Usuario();
            usuario.setId(1);

            while (linha != null) {
                campos = linha.split(";");

                Banho banho = new Banho(campos[0], Float.valueOf(campos[1]), Integer.valueOf(campos[2]),
                        Boolean.valueOf(campos[3]), Boolean.valueOf(campos[4]), Boolean.valueOf(campos[5]));

                banho.setUsuario(usuario);

                banhoService.create(banho);
                linha = reader.readLine();
            }

            fileReader.close();
            reader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("\n\tBanhos adicionados!\n");
        }
    }
}
