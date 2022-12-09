package br.edu.infnet.petshop.model.domain;

import br.edu.infnet.petshop.model.exceptions.IllegalMinutesServiceException;
import br.edu.infnet.petshop.model.exceptions.InvalidFieldException;
import br.edu.infnet.petshop.model.exceptions.NoPriceException;

public class Vacina extends Servico {
    private String tipo;
    private String marca;
    private float precoVacina;

    public Vacina(String nome, float preco, int tempoMinutos, String tipo, String marca, float precoVacina)
            throws InvalidFieldException, NoPriceException, IllegalMinutesServiceException {
        super(nome, preco, tempoMinutos);
        this.tipo = tipo;
        this.marca = marca;
        this.precoVacina = precoVacina;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrecoVacina() {
        return precoVacina;
    }

    public void setPrecoVacina(float precoVacina) {
        this.precoVacina = precoVacina;
    }

    @Override
    public float calcularValorAtendimento() throws NoPriceException {
        if (this.precoVacina <= 0) {
            throw new NoPriceException("O preço da vacina não pode ser igual ou menor que zero.");
        }
        return this.getPreco() + this.precoVacina;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(";");
        sb.append(tipo);
        sb.append(";");
        sb.append(marca);
        sb.append(";");
        sb.append(precoVacina);
        sb.append(";");
        try {
            sb.append("Valor total da Vacina: R$ " + this.calcularValorAtendimento());
        } catch (NoPriceException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return super.toString() + sb.toString();
    }
}
