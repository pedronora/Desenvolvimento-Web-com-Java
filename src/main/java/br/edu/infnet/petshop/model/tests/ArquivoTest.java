package br.edu.infnet.petshop.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.petshop.model.domain.Atendimento;
import br.edu.infnet.petshop.model.domain.Banho;
import br.edu.infnet.petshop.model.domain.Consulta;
import br.edu.infnet.petshop.model.domain.Pet;
import br.edu.infnet.petshop.model.domain.Servico;
import br.edu.infnet.petshop.model.domain.Vacina;
import br.edu.infnet.petshop.model.exceptions.AtendimentoSemPetException;
import br.edu.infnet.petshop.model.exceptions.AtendimentoSemServicosException;
import br.edu.infnet.petshop.model.exceptions.IllegalMinutesServiceException;
import br.edu.infnet.petshop.model.exceptions.InvalidFieldException;
import br.edu.infnet.petshop.model.exceptions.NoPriceException;

public class ArquivoTest {
    public static void main(String[] args) {
        String path = "src/main/resources/static/data/";
        String file = "atendimentos.txt";

        try {
            try {
                FileReader fileReader = new FileReader(path + file);
                BufferedReader reader = new BufferedReader(fileReader);

                FileWriter fileWriter = new FileWriter(path + "out_" + file);
                BufferedWriter writer = new BufferedWriter(fileWriter);

                List<Servico> servicos = new ArrayList<Servico>();
                Atendimento at = null;

                String linha = reader.readLine();
                String[] campos = null;
                while (linha != null) {

                    campos = linha.split(";");

                    switch (campos[0].toUpperCase()) {
                        case "A":
                            try {
                                Pet pet = new Pet(campos[1], campos[2], campos[3], campos[4], campos[5].charAt(0), Boolean.valueOf(campos[6]));

                                at = new Atendimento(pet, servicos);
                                at.setDescricao("Primeiro Atendimento");
                                at.setEmergencia(true);
                            } catch (InvalidFieldException | AtendimentoSemPetException
                                    | AtendimentoSemServicosException e) {
                                System.out.println("Erro: " + e.getMessage());
                            }
                            break;

                        case "B":
                            try {
                                Banho banho = new Banho(campos[1], Float.valueOf(campos[2]), Integer.valueOf(campos[3]), Boolean.valueOf(campos[4]), Boolean.valueOf(campos[5]), Boolean.valueOf(campos[6]));

                                servicos.add(banho);
                            } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
                                System.out.println("Erro: " + e.getMessage());
                            }
                            break;

                        case "C":
                            try {
                                Consulta consulta = new Consulta(campos[1], Float.valueOf(campos[2]), Integer.valueOf(campos[3]), Boolean.valueOf(campos[4]), campos[5], campos[6]);

                                servicos.add(consulta);
                            } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
                                System.out.println("Erro: " + e.getMessage());
                            }
                            break;

                        case "V":
                            try {
                                Vacina vacina = new Vacina(campos[1], Float.valueOf(campos[2]), Integer.valueOf(campos[3]), campos[4], campos[5], Float.valueOf(campos[6]));

                                servicos.add(vacina);
                            } catch (InvalidFieldException | NoPriceException | IllegalMinutesServiceException e) {
                                System.out.println("Erro: " + e.getMessage());
                            }
                            break;

                        default:
                            System.out.println("Registro Inválido.");
                            break;
                    }
                    linha = reader.readLine();
                }

                if (at != null) {
                    writer.write(at.obterLinha());
                }

                reader.close();
                fileReader.close();

                writer.close();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } finally {
            System.out.println("\t\nProcessamento realizado com sucesso!\n\n");
        }
    }
}
