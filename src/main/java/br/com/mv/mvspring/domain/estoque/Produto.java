package br.com.mv.mvspring.domain.estoque;

import br.com.mv.mvspring.domain.common.Entidade;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Produto extends Entidade implements Serializable {
    private static final long serialVersionUID = 4321892568358797728L;

    @Column
    private String nome;

    @Column
    private Double preco;

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "PRODUTOS_CATEGORIAS",
        joinColumns = @JoinColumn(name = "produto_id"),
        inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categorias = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public Produto() {
    }

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Produto produto = (Produto) o;

        if (nome != null ? !nome.equals(produto.nome) : produto.nome != null) return false;
        return preco != null ? preco.equals(produto.preco) : produto.preco == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (preco != null ? preco.hashCode() : 0);
        return result;
    }
}
