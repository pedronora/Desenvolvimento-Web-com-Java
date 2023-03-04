package br.edu.infnet.petshop.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.edu.infnet.petshop.model.exceptions.AtendimentoSemPetException;
import br.edu.infnet.petshop.model.exceptions.AtendimentoSemServicosException;

public class Atendimento {
    private Integer id = 0;
    private LocalDateTime data;
    private String descricao;
    private boolean emergencia;
    private Pet pet;
    private List<Servico> servicos;

    public Atendimento(Pet pet, List<Servico> servicos)
            throws AtendimentoSemPetException, AtendimentoSemServicosException {
        if (pet == null) {
            throw new AtendimentoSemPetException("Não existe Pet associada ao Atendimento.");
        }
        if (servicos == null) {
            throw new AtendimentoSemServicosException("Não existem Serviços associados ao Atendimento.");
        }
        this.data = LocalDateTime.now();
        this.pet = pet;
        this.servicos = servicos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isEmergencia() {
        return emergencia;
    }

    public void setEmergencia(boolean emergencia) {
        this.emergencia = emergencia;
    }

    public Pet getPet() {
        return pet;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return String.format("%s;%s;%s",
                data.format(formatter),
                descricao,
                emergencia ? "Emergência" : "Normal");
    }

    public void imprimir() {
        System.out.println("\n\tPedido: " + this);
        System.out.println("\tPet: " + this.pet);
        System.out.println("\tQtd de Serviços: " + servicos.size());
        System.out.println("\tServiços:");
        for (Servico servico : servicos) {
            System.out.println("\t\t- " + servico.getNome());
        }
    }

    public String obterLinha() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
        return this.getData().format(formatter) + ";" +
                this.getDescricao() + ";" +
                this.getPet() + ";" +
                this.getServicos().size() + "\r\n";
    }
}
