package br.edu.infnet.petshop;

import java.io.BufferedReader;
import java.io.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.petshop.model.domain.Usuario;
import br.edu.infnet.petshop.model.domain.Vacina;
import br.edu.infnet.petshop.service.VacinaService;

@Component
public class VacinaLoader implements ApplicationRunner {
    @Autowired
    VacinaService vacinaService;

    String path = "src/main/resources/static/data/";
    String file = "vacina.txt";

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

                Vacina vacina = new Vacina(campos[0], Float.valueOf(campos[1]), Integer.valueOf(campos[2]), campos[3],
                        campos[4], Float.valueOf(campos[5]));
                
                vacina.setUsuario(usuario);
                vacinaService.create(vacina);
                linha = reader.readLine();
            }

            fileReader.close();
            reader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("\n\tVacinas adicionadas!\n");
        }
    }
}
