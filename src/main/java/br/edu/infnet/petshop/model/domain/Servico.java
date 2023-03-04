package br.edu.infnet.petshop.model.domain;

import br.edu.infnet.petshop.model.exceptions.IllegalMinutesServiceException;
import br.edu.infnet.petshop.model.exceptions.InvalidFieldException;
import br.edu.infnet.petshop.model.exceptions.NoPriceException;

public abstract class Servico {
    private Integer id = 0;
    private String nome;
    private float preco;
    private int tempoMinutos;

    public Servico(String nome, float preco, int tempoMinutos) throws InvalidFieldException, NoPriceException, IllegalMinutesServiceException {
        checkParameter(nome, "nome");
        
        if (preco <= 0) {
            throw new NoPriceException("O preço do serviço deve ser maior que zero.");
        }

        if (tempoMinutos <= 10) {
            throw new IllegalMinutesServiceException("O tempo de serviço deve ser maior que 10 minutos");
        }
        
        this.nome = nome;
        this.preco = preco;
        this.tempoMinutos = tempoMinutos;
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

    public float getPreco() {
        return preco;
    }

    public int getTempoMinutos() {
        return tempoMinutos;
    }

    public abstract float calcularValorAtendimento() throws NoPriceException;

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

    public void checkParameter(String field, String attr) throws InvalidFieldException {
        if (field == null || field.isBlank()) {
            throw new InvalidFieldException("O campo [" + attr + "] não pode ser nulo/branco.");
        }
    }
}
