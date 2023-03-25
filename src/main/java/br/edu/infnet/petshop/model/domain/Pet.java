package br.edu.infnet.petshop.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.edu.infnet.petshop.model.exceptions.InvalidFieldException;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String dataNasc;
    private String especie;
    private String raca;
    private char genero;
    private boolean castrado;
    @ManyToOne
    @JoinColumn(name = "id_Usuario")
    private Usuario usuario;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_Endereco")
    private Endereco endereco;

    public Pet() {

    }

    public Pet(String nome, String dataNasc, String especie, String raca, char genero, boolean castrado)
            throws InvalidFieldException {
        checkParameter(nome, "nome");
        checkParameter(especie, "especie");
        checkParameter(raca, "raca");
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.especie = especie;
        this.raca = raca;
        this.genero = genero;
        this.castrado = castrado;
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

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void checkParameter(String field, String attr) throws InvalidFieldException {
        if (field == null || field.isBlank()) {
            throw new InvalidFieldException("O campo [" + attr + "] não pode ser nulo/branco.");
        }
    }
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nome + ";");
        sb.append(dataNasc + ";");
        sb.append(especie + ";");
        sb.append(raca + ";");
        sb.append((genero == 'M') ? "Macho;" : "Fêmea;");
        sb.append(castrado ? "Castrado" : "Não castrado");
        return sb.toString();
    }
}
