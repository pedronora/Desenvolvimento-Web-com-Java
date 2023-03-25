package br.edu.infnet.petshop.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String senha;
    private String email;
    @OneToMany
    @JoinColumn(name = "id_Usuario")
    private List<Pet> pets; 
    @OneToMany
    @JoinColumn(name = "id_Usuario")
    private List<Servico> servicos; 
    @OneToMany
    @JoinColumn(name = "id_Usuario")
    private List<Atendimento> atendimentos;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_Endereco")
    private Endereco endereco;

    public Usuario() {
    }

    public Usuario(String email, String senha) {
        this.setEmail(email);
        this.setSenha(senha);
    }

    public Usuario(String nome, String email, String senha) {
        this(email, senha);
        this.setNome(nome);
    }

    @Override
    public String toString() {

        return String.format(
                "%s tem as credenciais: Login: %s e Senha: %s.",
                nome,
                email,
                senha);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }    
}
