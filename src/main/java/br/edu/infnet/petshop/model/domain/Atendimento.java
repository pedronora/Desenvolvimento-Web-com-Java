package br.edu.infnet.petshop.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.edu.infnet.petshop.model.exceptions.AtendimentoSemPetException;
import br.edu.infnet.petshop.model.exceptions.AtendimentoSemServicosException;

@Entity
public class Atendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime data;
    private String descricao;
    private boolean emergencia;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_Pet")
    private Pet pet;
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Servico> servicos;
    @ManyToOne
    @JoinColumn(name = "id_Usuario")
    private Usuario usuario;

    public Atendimento() {
    }

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

    public void setData(LocalDateTime data) {
        this.data = data;
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

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
