package br.edu.infnet.petshop.model.domain;

import javax.persistence.Entity;

import br.edu.infnet.petshop.model.exceptions.IllegalMinutesServiceException;
import br.edu.infnet.petshop.model.exceptions.InvalidFieldException;
import br.edu.infnet.petshop.model.exceptions.NoPriceException;

@Entity
public class Banho extends Servico {
    private boolean hidratarPelo;
    private boolean cortarUnhas;
    private boolean escovarDentes;

    public Banho() {
    }

    public Banho(String nome, float preco, int tempoMinutos, boolean hidratarPelo, boolean cortarUnhas,
            boolean escovarDentes) throws InvalidFieldException, NoPriceException, IllegalMinutesServiceException {
        super(nome, preco, tempoMinutos);
        this.hidratarPelo = hidratarPelo;
        this.cortarUnhas = cortarUnhas;
        this.escovarDentes = escovarDentes;
    }

    public boolean isHidratarPelo() {
        return hidratarPelo;
    }

    public void setHidratarPelo(boolean hidratarPelo) {
        this.hidratarPelo = hidratarPelo;
    }

    public boolean isCortarUnhas() {
        return cortarUnhas;
    }

    public void setCortarUnhas(boolean cortarUnhas) {
        this.cortarUnhas = cortarUnhas;
    }

    public boolean isEscovarDentes() {
        return escovarDentes;
    }

    public void setEscovarDentes(boolean escovarDentes) {
        this.escovarDentes = escovarDentes;
    }

    @Override
    public float calcularValorAtendimento() {
        float preco = this.getPreco();
        if (hidratarPelo) {
            preco += 5.9;
        }
        if (cortarUnhas) {
            preco += 2;
        }
        if (escovarDentes) {
            preco += 7;
        }
        return preco;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(";");
        sb.append(hidratarPelo ? "Hidratar pelos" : "Não hidratar pelos");
        sb.append(";");
        sb.append(cortarUnhas ? "Cortar unhas" : "Não cortar unhas");
        sb.append(";");
        sb.append(escovarDentes ? "Escovar dentes" : "Não escovar dentes");
        sb.append(";");
        sb.append("Valor total do banho: R$ " + this.calcularValorAtendimento());
        return super.toString() + sb.toString();
    }
}
