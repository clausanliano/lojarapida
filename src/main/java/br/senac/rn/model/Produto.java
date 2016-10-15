package br.senac.rn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import br.senac.rn.dao.PersistDB;

@Entity
public class Produto implements PersistDB {
	
    @Id
    @GeneratedValue
    private int id;
    private String denominacao;
    private String descricao;
    private Double preco;
    @ManyToOne
    private Categoria categoria;

    public Produto() {}

    public Produto(int id) {
        this.id = id;
    }
    
    public Produto(int id, String denominacao, String descricao, Double preco) {
        this.id = id;
        this.denominacao = denominacao;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenominacao() {
        return denominacao;
    }

    public void setDenominacao(String denominacao) {
        this.denominacao = denominacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    } 
    
}
