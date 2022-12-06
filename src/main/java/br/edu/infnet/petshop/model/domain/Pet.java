package br.edu.infnet.petshop.model.domain;

public class Pet {
    private String nome;
    private String dataNasc;
    private String especie;
    private String raca;
    private char genero;
    private boolean castrado;

    public Pet(String nome, String dataNasc, String especie, String raca, char genero, boolean castrado) {
        checkParameter(nome);
        checkParameter(especie);
        checkParameter(raca);
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.especie = especie;
        this.raca = raca;
        this.genero = genero;
        this.castrado = castrado;
    }

    public Pet(Pet source) {
        this.nome = source.nome;
        this.dataNasc = source.dataNasc;
        this.especie = source.especie;
        this.raca = source.raca;
        this.genero = source.genero;
        this.castrado = source.castrado;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    public char getGenero() {
        return genero;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public void checkParameter(String field) {
        if (field == null || field.isBlank()) {
            throw new IllegalArgumentException("campo não pode ser nulo ou em branco");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nome + ";");
        sb.append(dataNasc + ";");
        sb.append(especie + ";");
        sb.append(raca + ";");
        sb.append((genero == 'M') ? "Macho" : "Fêmea" + ";");
        sb.append(castrado ? "Castrado" : "Não castrado");
        return sb.toString();
    }
}
