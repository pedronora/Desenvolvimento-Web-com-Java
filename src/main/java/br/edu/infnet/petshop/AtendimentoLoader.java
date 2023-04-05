package br.edu.infnet.petshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.petshop.model.domain.Atendimento;
import br.edu.infnet.petshop.model.domain.Banho;
import br.edu.infnet.petshop.model.domain.Consulta;
import br.edu.infnet.petshop.model.domain.Pet;
import br.edu.infnet.petshop.model.domain.Servico;
import br.edu.infnet.petshop.model.domain.Usuario;
import br.edu.infnet.petshop.model.domain.Vacina;
import br.edu.infnet.petshop.service.AtendimentoService;

@Order(6)
@Component
public class AtendimentoLoader implements ApplicationRunner {

    @Autowired
    AtendimentoService atendimentoService;

    String path = "src/main/resources/static/data/";
    String file = "atendimento.txt";

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            FileReader fileReader = new FileReader(path + file);
            BufferedReader reader = new BufferedReader(fileReader);

            String linha = reader.readLine();
            String[] campos = null;

            Usuario novoUsuario = new Usuario();
            Pet novoPet = new Pet();

            Banho servico1 = new Banho();
            Consulta servico2 = new Consulta();
            Vacina servico3 = new Vacina();

            novoUsuario.setId(1);
            novoPet.setId(1);
            servico1.setId(1);
            servico2.setId(6);
            servico3.setId(11);

            List<Servico> servicos = Arrays.asList(servico1, servico2, servico3);

            while (linha != null) {
                campos = linha.split(";");

                Atendimento atendimento = new Atendimento(campos[0], campos[1],
                        Boolean.valueOf(campos[2]));

                atendimento.setUsuario(novoUsuario);
                atendimento.setPet(novoPet);
                atendimento.setServicos(servicos);

                atendimentoService.create(atendimento);
                linha = reader.readLine();
            }

            fileReader.close();
            reader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("\n\tAtendimentos adicionados!\n");
        }
    }
}
