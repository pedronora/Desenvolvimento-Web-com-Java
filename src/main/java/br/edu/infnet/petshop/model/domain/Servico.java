package br.edu.infnet.petshop.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.edu.infnet.petshop.model.exceptions.IllegalMinutesServiceException;
import br.edu.infnet.petshop.model.exceptions.InvalidFieldException;
import br.edu.infnet.petshop.model.exceptions.NoPriceException;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private float preco;
    private int tempoMinutos;
    @ManyToOne
	@JoinColumn(name = "id_Usuario")
	private Usuario usuario;
    @ManyToMany(mappedBy = "servicos")
	private List<Atendimento> atendimentos; 

    public Servico() {
    }

    public Servico(String nome, float preco, int tempoMinutos)
            throws InvalidFieldException, NoPriceException, IllegalMinutesServiceException {
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getTempoMinutos() {
        return tempoMinutos;
    }

    public void setTempoMinutos(int tempoMinutos) {
        this.tempoMinutos = tempoMinutos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
