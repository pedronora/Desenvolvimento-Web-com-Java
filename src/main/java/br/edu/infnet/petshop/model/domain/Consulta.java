package br.edu.infnet.petshop.model.domain;

import br.edu.infnet.petshop.model.exceptions.IllegalMinutesServiceException;
import br.edu.infnet.petshop.model.exceptions.InvalidFieldException;
import br.edu.infnet.petshop.model.exceptions.NoPriceException;

public class Consulta extends Servico {
    private boolean plantao;
    private String diagnostico;
    private String receita;

    public Consulta(String nome, float preco, int tempoMinutos, boolean plantao, String descricao, String receita)
            throws InvalidFieldException, NoPriceException, IllegalMinutesServiceException {
        super(nome, preco, tempoMinutos);
        this.plantao = plantao;
        this.diagnostico = descricao;
        this.receita = receita;
    }

    public boolean isPlantao() {
        return plantao;
    }

    public void setPlantao(boolean plantao) {
        this.plantao = plantao;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String descricao) {
        this.diagnostico = descricao;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

    @Override
    public float calcularValorAtendimento() {
        return plantao ? (this.getPreco() + 75) : (this.getPreco());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(";");
        sb.append(plantao ? "Plantão" : "Normal");
        sb.append(";");
        sb.append(diagnostico);
        sb.append(";");
        sb.append(receita);
        sb.append(";");
        sb.append("Valor total da Consulta: R$ " + this.calcularValorAtendimento());
        return super.toString() + sb.toString();
    }
}
