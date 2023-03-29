package br.edu.infnet.petshop;

import java.io.BufferedReader;
import java.io.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.petshop.model.domain.Pet;
import br.edu.infnet.petshop.model.domain.Usuario;
import br.edu.infnet.petshop.service.PetService;

@Order(2)
@Component
public class PetLoader implements ApplicationRunner {

    @Autowired
    PetService petService;

    String path = "src/main/resources/static/data/";
    String file = "pet.txt";

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            FileReader fileReader = new FileReader(path + file);
            BufferedReader reader = new BufferedReader(fileReader);

            String linha = reader.readLine();
            String[] campos = null;

            Usuario novoUsuario = new Usuario();
            
            int n = 1;

            while (linha != null) {
            campos = linha.split(";");

            Pet pet = new Pet(campos[0], campos[1],
            campos[2], campos[3],campos[4].charAt(0), Boolean.valueOf(campos[5]));
            novoUsuario.setId(n++);
            pet.setUsuario(novoUsuario);

            petService.create(pet);
            linha = reader.readLine();
            }

            fileReader.close();
            reader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("\n\tPets adicionados!\n");
        }
    }
}
