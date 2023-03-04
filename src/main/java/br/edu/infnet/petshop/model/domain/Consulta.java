package br.edu.infnet.petshop.model.domain;

import br.edu.infnet.petshop.model.exceptions.IllegalMinutesServiceException;
import br.edu.infnet.petshop.model.exceptions.InvalidFieldException;
import br.edu.infnet.petshop.model.exceptions.NoPriceException;

public class Consulta extends Servico {
    private Integer id = 0;
    private boolean plantao;
    private String descricao;
    private String receita;

    public Consulta(String nome, float preco, int tempoMinutos, boolean plantao, String descricao, String receita)
            throws InvalidFieldException, NoPriceException, IllegalMinutesServiceException {
        super(nome, preco, tempoMinutos);
        super.checkParameter(descricao, "descricao");
        super.checkParameter(receita, "receita");
        this.plantao = plantao;
        this.descricao = descricao;
        this.receita = receita;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isPlantao() {
        return plantao;
    }

    public void setPlantao(boolean plantao) {
        this.plantao = plantao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws InvalidFieldException {
        super.checkParameter(descricao, "descricao");
        this.descricao = descricao;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) throws InvalidFieldException {
        super.checkParameter(receita, "receita");
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
        sb.append(descricao);
        sb.append(";");
        sb.append(receita);
        sb.append(";");
        sb.append("Valor total da Consulta: R$ " + this.calcularValorAtendimento());
        return super.toString() + sb.toString();
    }
}
