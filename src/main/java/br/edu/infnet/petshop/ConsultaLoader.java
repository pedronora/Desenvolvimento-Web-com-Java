package br.edu.infnet.petshop;

import java.io.BufferedReader;
import java.io.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.petshop.model.domain.Consulta;
import br.edu.infnet.petshop.service.ConsultaService;

@Component
public class ConsultaLoader implements ApplicationRunner {

    @Autowired
    ConsultaService consultaService;

    String path = "src/main/resources/static/data/";
    String file = "consulta.txt";

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try {
            FileReader fileReader = new FileReader(path + file);
            BufferedReader reader = new BufferedReader(fileReader);

            String linha = reader.readLine();
            String[] campos = null;

            while (linha != null) {
                campos = linha.split(";");

                Consulta vacina = new Consulta(campos[0], Float.valueOf(campos[1]), Integer.valueOf(campos[2]),
                        Boolean.valueOf(campos[3]), campos[4], campos[5]);

                consultaService.create(vacina);
                linha = reader.readLine();
            }

            fileReader.close();
            reader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("\n\tConsultas adicionadas!\n");
        }
    }
}
