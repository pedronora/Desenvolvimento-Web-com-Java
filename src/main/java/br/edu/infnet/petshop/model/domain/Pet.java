package br.edu.infnet.petshop.model.domain;

import br.edu.infnet.petshop.model.exceptions.InvalidFieldException;

public class Pet {
    private Integer id = 0;
    private String nome;
    private String dataNasc;
    private String especie;
    private String raca;
    private char genero;
    private boolean castrado;

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

    public void checkParameter(String field, String attr) throws InvalidFieldException {
        if (field == null || field.isBlank()) {
            throw new InvalidFieldException("O campo [" + attr + "] não pode ser nulo/branco.");
        }
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
