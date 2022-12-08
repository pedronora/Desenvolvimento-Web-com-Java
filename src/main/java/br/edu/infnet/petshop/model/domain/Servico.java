package br.edu.infnet.petshop.model.domain;

public abstract class Servico {
    private String nome;
    private float preco;
    private int tempoMinutos;

    public Servico(String nome, float preco, int tempoMinutos) {
        this.nome = nome;
        this.preco = preco;
        this.tempoMinutos = tempoMinutos;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public int getTempoMinutos() {
        return tempoMinutos;
    }

    public abstract float calcularValorAtendimento();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nome);
        sb.append(";");
        sb.append(preco);
        sb.append(";");
        sb.append(tempoMinutos);
        return sb.toString();
    }
}
